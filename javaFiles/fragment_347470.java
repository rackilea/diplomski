Cursor data = mDatabaseRecipes.getData();
ArrayList<String> listData = new ArrayList<>();
while(data.moveToNext()){
    //get the value from the database in column 1
    //then add it to the ArrayList
    listData.add(data.getString(1));
    recipesList.add(new Recipe(data.get(NAME_COLUMN), data.get(RECIPE_COLUMN));
}