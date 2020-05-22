SQLiteDatabase database = this.openOrCreateDatabase("ee",MODE_PRIVATE,null);
database.execSQL("CREATE TABLE IF NOT EXISTS users (name VARCHAR, age INT(3),id INT(3),house VARCHAR,street VARCHAR)");
database.execSQL("ALTER TABLE users ADD COLUMN street VARCHAR"); //<<<< ADDED
database.execSQL("INSERT INTO users (name,age,id,house,street) VALUES ('ROB',34,33,'home','street')");
....... rest of your code

}