Entity e1 = new Entity();
e1.setId(400);

Entity e2 = new Entity();
e2.setId(300);
e2.setParentId(400);

Entity e3 = new Entity();
e3.setId(200);
e3.setParentId(300);

Entity e4 = new Entity();
e4.setId(100);
e4.setParentId(200);

Entity e5 = new Entity();
e5.setId(50);
e5.setParentId(100);

Entity e6 = new Entity();
e6.setId(25); // this Id must be set, or we'll get a NPE
e6.setParentId(50);