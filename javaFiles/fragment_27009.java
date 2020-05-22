if (cursor == null) {
    return null;
} else if (!cursor.moveToFirst()) {
    cursor.close();
    return null;
}