while (cursor.moveToNext()){
        DataModel item = new DataModel();
        item.setItemId(cursor.getInt(
                cursor.getColumnIndex(ItemsTable.COL_ID)));
        item.setItemName(cursor.getString(
                cursor.getColumnIndex(ItemsTable.COL_NAME)));
        item.setItemCommonName(cursor.getString(
                cursor.getColumnIndex(ItemsTable.COL_COMMON_NAME)));
        item.setItemSciName(cursor.getString(
                cursor.getColumnIndex(ItemsTable.COL_SCI_NAME)));
        dataModels.add(item);
    }
    return dataModels;
}