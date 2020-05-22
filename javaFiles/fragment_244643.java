try {
    while (cursor.moveToNext()) {
        ...
    }
} finally {
    cursor.close();
}