public Child parseJackson(String jsonRequest) {
  // what we need
  ObjectMapper mapper;
  JsonNode root, parentNode;

  // your models
  Child child;
  Parent parent;

  // assign
  mapper = new ObjectMapper();
  root = mapper.readTree(jsonRequest); // deserialize JSON as tree
  parentNode = root.get("parent"); // get the "parent" branch

  // assign (again)
  child = mapper.readValue(root, Child.class);
  parent = mapper.readValue(parentNode, Parent.class);

  child.setParent(parent);

  return child;
}