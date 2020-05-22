public class JacksonMapSubset {

    public static void main(String[] args) throws JsonProcessingException {
        final Map<String, String> map = new HashMap<>();
        map.put("key 1", "value 1");
        map.put("key 2", "value 2");
        map.put("_internal key 1", "value 3");
        map.put("_internal key 2", "value 4");

        ObjectMapper mapper = new ObjectMapper();

        SimpleFilterProvider filters = new SimpleFilterProvider();
        final String filterName = "exclude-starting-with-underscore";
        mapper.setAnnotationIntrospector(new JacksonAnnotationIntrospector() {
            @Override
            public Object findFilterId(Annotated a) {
                if (Map.class.isAssignableFrom(a.getRawType())) {
                    return filterName;
                }
                return super.findFilterId(a);
            }
        });
        filters.addFilter(filterName, new SimpleBeanPropertyFilter() {
            @Override
            protected boolean include(BeanPropertyWriter writer) {
                return true;
            }

            @Override
            protected boolean include(PropertyWriter writer) {
                return !writer.getName().startsWith("_");
            }
        });

        mapper.setFilters(filters);
        System.out.println(mapper.writeValueAsString(map));
    }
}