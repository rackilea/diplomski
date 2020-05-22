String arraylistA[];
...
yourCursor.moveToNext();
i = 0;

...
arraylistA[i] = { (yourCursor.getString(yourCursor.getColumnIndex(YourDBHelper.yourcolumnnameA))};
i + 1;
                                            or
arraylistA[i] = { (yourCursor.getString(yourCursor.getColumnIndex("yourcolumnnameA"))};
i + 1;