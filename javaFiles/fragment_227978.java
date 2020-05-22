if (cursor.moveToFirst()) {
    while (cursor.isAfterLast() == false) {
        // do everything here first
        ID_Array.add(....)
        .....
        .....


        // only move to next cursor position at end of while loop
        cursor.moveToNext();
    }
}