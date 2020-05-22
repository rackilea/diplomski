if (c.getCount() > 0) {
    c.moveToFirst();
    do {
        result.add(new Item(
                c.getString(0),
                c.getString(1),
                c.getString(2),
                c.getString(3),
                c.getString(4)));
    } while (c.moveToNext());
}