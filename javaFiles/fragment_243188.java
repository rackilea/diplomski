int orderNum;
for ( cursor.moveToFirst; !cursor.isAfterLast(); cursor.moveToNext )
{
    int id = cursor.getInt( cursor.getColumnIndex( "item_id" ) );
    orderNum = cursor.getInt( cursor.getColumnIndex( "order_num" ) );
    String name = cursor.getString( cursor.getColumnIndex( "item_name" ) );

    list.add( new Item( id, orderNum, name ) );
}

map.put( orderNum, list );