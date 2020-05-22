ModelMapper modelMapper = new ModelMapper();

Converter<ObjectOne, ObjectTwo> converter = new Converter<ObjectOne, ObjectTwo>() {
    public ObjectTwo convert(MappingContext<ObjectOne, ObjectTwo> context) {

        ObjectTwo dest = new ObjectTwo();
        if (context.getSource() != null) {

            // Converts list from source object into the list of destination object
            Type listType = new TypeToken<List<ObjectTwo>>() {}.getType();
            List<ObjectTwo> items = modelMapper.map(context.getSource().getList(), listType);

            dest.getList().addAll(items);
            return dest;

        } else {
            return dest;
        }
    }
};