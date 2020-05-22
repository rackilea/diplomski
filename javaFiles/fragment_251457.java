@AllArgsConstructor
public class GenericPojoCsvSchemaBuilder {

    public CsvSchema build(final Class<?> type) {
        return build(type, null);
    }

    public CsvSchema build(final Class<?> type, final Class<?> view) {
        return build(CsvSchema.builder(), type, view);
    }

    public CsvSchema build(final CsvSchema.Builder builder, final Class<?> type) {
        return build(builder, type, null);
    }

    public CsvSchema build(final CsvSchema.Builder builder, final Class<?> type, final Class<?> view) {
        final JsonPropertyOrder propertyOrder = type.getAnnotation(JsonPropertyOrder.class);

        final List<Field> fieldsForView;

        // DO NOT use Arrays.asList because it uses an internal fixed length implementation which cannot use .removeAll (throws UnsupportedOperationException)
        final List<Field> unorderedFields = Arrays.stream(type.getDeclaredFields()).collect(Collectors.toList());

        if (propertyOrder != null && propertyOrder.value().length > 0) {
            final List<Field> orderedFields = Arrays.stream(propertyOrder.value()).map(s -> {
                try {
                    return type.getDeclaredField(s);
                } catch (final NoSuchFieldException e) {
                    throw new IllegalArgumentException(e);
                }
            }).collect(Collectors.toList());

            if (propertyOrder.value().length < type.getDeclaredFields().length) {
                unorderedFields.removeAll(orderedFields);
                orderedFields.addAll(unorderedFields);
            }

            fieldsForView = getJsonViewFields(orderedFields, view);
        } else {
            fieldsForView = getJsonViewFields(unorderedFields ,view);
        }

        final JsonIgnoreFieldFilter ignoreFieldFilter = new JsonIgnoreFieldFilter(type.getDeclaredAnnotation(JsonIgnoreProperties.class));

        fieldsForView.forEach(field -> {
            if (ignoreFieldFilter.matches(field)) {
                builder.addColumn(field.getName());
            }
        });

        return builder.build();
    }

    private List<Field> getJsonViewFields(final List<Field> fields, final Class<?> view) {
        if (view == null) {
            return fields;
        }

        return fields.stream()
                .filter(field -> {
                    final JsonView jsonView = field.getAnnotation(JsonView.class);
                    return jsonView != null && Arrays.stream(jsonView.value()).anyMatch(candidate -> candidate.isAssignableFrom(view));
                })
                .collect(Collectors.toList());
    }

    private class JsonIgnoreFieldFilter implements ReflectionUtils.FieldFilter {

        private final List<String> fieldNames;

        public JsonIgnoreFieldFilter(final JsonIgnoreProperties jsonIgnoreProperties) {
            if (jsonIgnoreProperties != null) {
                fieldNames = Arrays.asList(jsonIgnoreProperties.value());
            } else {
                fieldNames = null;
            }
        }

        @Override
        public boolean matches(final Field field) {
            if (fieldNames !=  null && fieldNames.contains(field.getName())) {
                return false;
            }

            final JsonIgnore jsonIgnore = field.getDeclaredAnnotation(JsonIgnore.class);
            return jsonIgnore == null || !jsonIgnore.value();
        }
    }
}