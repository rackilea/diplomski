Formatters.register(ObjectId.class, new SimpleFormatter<ObjectId>() {

    @Override
    public ObjectId parse(String input, Locale l) throws ParseException {

        return ...; // create the object from the input of the form
    }

    @Override
    public String print(ObjectId objectId, Locale l) {
        return String.valueOf(objectId.id);
    }

});