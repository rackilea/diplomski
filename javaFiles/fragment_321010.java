String test = "\u0627\u0644\u0633\u0644\u0627\u0645";
PersistenceManager manager = PMF.get().getPersistenceManager();
Category category = new Category(test);
manager.makePersistent(category);
manager.refresh(category);
manager.close();