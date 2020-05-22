@JsonFilter("pojo-filter")
class Pojo {
    public int foo;
}

FilterProvider filters = new SimpleFilterProvider()
    .addFilter("pojo-filter", new SimpleBeanPropertyFilter() {
        @Override
        protected boolean include(PropertyWriter writer) {
            return "foo".equals(writer.getName()) 
                ? Random.nextBoolean()
                : true;
        }
    });

new ObjectMapper().writer().filters(filters).write(new Pojo());