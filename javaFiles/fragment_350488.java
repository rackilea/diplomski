testDB=mock(DatabaseModel.class);

// constructor injection
controller=new Controller(testDB);

// setter injection
controller=new Controller();
controller.setDatabaseModel(testDB);