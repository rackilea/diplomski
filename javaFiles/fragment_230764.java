database = Room.databaseBuilder(this, Database.class, "database")
            .allowMainThreadQueries()
            .build();
    Log.d("ITEMSINDB",String.valueOf(database.classDao().getItemsInDatabase()));
    if (database.classDao().getItemsInDatabase() < 1) {
        ClassEntity myClassEntity = new ClassEntity();
        myClassEntity.id_of_a_group = "myfirstid";
        myClassEntity.monday = "something on Monday";
        myClassEntity.tuesday = "on Tuesday";
        myClassEntity.wednesday = "another on Wed";
        myClassEntity.thursday = "this on Thurs";
        myClassEntity.friday = "TGIF";
        database.classDao().insert(myClassEntity);
    }
    Log.d("ITEMSINDB",String.valueOf(database.classDao().getItemsInDatabase()));