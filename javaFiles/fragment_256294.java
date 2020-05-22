public void addImageToRecipe(byte[] image, Recipe recipe) {

    SQLiteDatabase db = this.getWritableDatabase();

    db.beginTransaction();
    try {
        ContentValues values = new  ContentValues();
        values.put(COLUMN_IMAGE_ID, image);
        db.update(TABLE_RECIPES, values, COLUMN_RECIPE_NAME + "=\"" + recipe.getRecipeTitle() + "\"", null);

        db.setTransactionSuccessful();   // This line commits the current transaction

    } finally {
        db.endTransaction();
    }
    db.close();
}