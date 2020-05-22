@Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_FOOD_TABLE = "CREATE TABLE " + TABLE_FOOD +" (id INTEGER PRIMARY KEY,Food_category TEXT,Food_item TEXT,Proteins REAL,Fat REAL,carb REAL,calories REAL)";
        db.execSQL(CREATE_FOOD_TABLE);
        // execute your insert commands here to insert data only once  
        addfood(new food_items("Dairy and Egg Products","Milk",0f,0f,0f,0f),db);
        addfood(new food_items("Spices and Herbs","Milk",0f,0f,0f,0f),db);
        addfood(new food_items("Fats and Oils","Milk",0f,0f,0f,0f),db);
        addfood(new food_items("Soups, Sauces, and Gravies","Milk",0f,0f,0f,0f),db);
        addfood(new food_items("Fruits","Milk",0f,0f,0f,0f),db);
        addfood(new food_items("Vegetables","Milk",0f,0f,0f,0f),db);
        db.close(); // Closing database connection
    }