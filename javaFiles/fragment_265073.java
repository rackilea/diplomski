while (cursor.moveToNext()) {
        ProductCategoryDatabaseRetrieve prodCatDB = new ProductCategoryDatabaseRetrieve();//Instantiate here with each iteration.
        prodCatDB.set_tid(cursor.getInt(cursor.getColumnIndex(DatabaseHandler._TID)));
        prodCatDB.setTid(String.valueOf(cursor.getInt(cursor
                .getColumnIndex(DatabaseHandler.TID))));
        prodCatDB.setProductCategoryName(cursor.getString(cursor
                .getColumnIndex(DatabaseHandler.PRODUCT_CATEGORY_NAME)));
        prodCatDB.setProductCategoryImage(cursor.getBlob(cursor
                .getColumnIndex(DatabaseHandler.PRODUCT_CATEGORY_IMAGE)));
        productCategoryDatabaseRetrieve.add(prodCatDB);
}