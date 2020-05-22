ObjectMapper mapper = new ObjectMapper();
SimpleFilterProvider simpleFilterProvider = new SimpleFilterProvider()
    .addFilter("myUser", simpleBeanPropertyFilter.filterOutAllExcept("username"));

mapper.setFilters(filterProvider);
return mapper.writeValueAsString(user);