ArrayList<Category> cats = new ArrayList<>();
cats.add(new Category("Cat 1"));
cats.add(new Category("Cat 2"));

GenericEntity<List<Category>> entity = new GenericEntity<List<Category>>(cats){};
return Response.ok(entity).build();