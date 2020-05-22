cursorA = db.query(...);
cursorB = db.query(...);
cursorB.moveToFirst();
while (cursorA.moveToNext()) {
    id = cursor.getInt(0);
    a = new ObjectA(id, ...);
    while (!cursorB.isAfterLast() &&
           cursorB.getInt(0) == id) {
        b = new ObjectB(...);
        a.addB(b);
        cursorB.moveToNext();
    }
}