final PageRequest page1 = new PageRequest(
  0, 20, Direction.ASC, "lastName", "salary"
);

final PageRequest page2 = new PageRequest(
  0, 20, new Sort(
    new Order(Direction.ASC, "lastName"), 
    new Order(Direction.DESC, "salary")
  )
);

dao.findAll(page1);