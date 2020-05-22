do {
...
if (trenutnovrijeme > bazavrijeme)
                {
                    dan = dan+1;
                    dani(dan);
                    CursorDan = DatabaseManager.getAllDataDay(danString);
                }
....
}
while (CursorDan.moveToNext());