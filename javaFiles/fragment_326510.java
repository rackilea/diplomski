public void addfood(food_items food_item, SQLiteDatabase db ) {
        ContentValues values = new ContentValues();
        values.put(FOOD_CATEGORY, food_item.getfood_category());
        values.put(FOOD_ITEM, food_item.getfood_item());
        values.put(PROTEINS, food_item.getproteins());
        values.put(FAT, food_item.getfat());
        values.put(CARB, food_item.getcarb());
        values.put(CALORIES, food_item.getcalorie());

        db.insert(TABLE_FOOD, null, values);
    }