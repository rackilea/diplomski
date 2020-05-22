class FieldDtoConvertor implements Converter {
    @SuppressWarnings("unchecked")
    public boolean canConvert(final Class clazz) {
        return clazz.equals(FieldDto.class);
    }

    public void marshal(final Object value,
            final HierarchicalStreamWriter writer,
            final MarshallingContext context) {
        final FieldDto fieldDto = (FieldDto) value;
        writer.addAttribute(fieldDto.getAttributeName(), fieldDto.getAttributeValue());     
    }
}