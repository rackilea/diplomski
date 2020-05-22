EntityOne entityOne = new EntityOne();
entityOne.setProperty("Some Value");

EntityTwo entityTwo_1 = new EntityTwo();
entityTwo_1.setName("Something"); 

EntityTwo entityTwo_2 = new EntityTwo();
entityTwo_2.setName("Something"); 

entityOne.addChild(entityTwo_1);
entityOne.addChild(entityTwo_2);

entityManager.persist(entityOne);