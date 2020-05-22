private static final Comparator<FieldError> FIELD_ORDER_COMPARATOR = new Comparator<FieldError>() {

    // Your fields, ordered in the way they appear in the form
    private static final List<String> FIELDS_WITH_ORDER = ImmutableList.of("field1", "field2");

    @Override
    public int compare(FieldError fe1, FieldError fe2) {

        String field1 = fe1.getField();
        String field2 = fe2.getField();

        int field1Index = FIELDS_WITH_ORDER.indexOf(field1);
        int field2Index = FIELDS_WITH_ORDER.indexOf(field2);

        return NumberUtils.compare(field1Index, field2Index);
    }
});

...

List<FieldError> fieldErrors = bindingResult.getFieldErrors();
Collections.sort(fieldErrors, FIELD_ORDER_COMPARATOR);