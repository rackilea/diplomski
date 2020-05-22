for(int i = 0; i < ArraySource.size(); i++) {
                List<String> firstList = new ArrayList<>();
                List<String> secondList = new ArrayList<>();
                Cursor sourceCursor = myDB.rawQuery("SELECT * FROM '" + ArraySource.get(i) + "';", null);

                if(sourceCursor != null) {
                    if(sourceCursor.moveToFirst()) {
                        do {
                            String a = sourceCursor.getString(0);
                            firstList.add(a);
                        } while(sourceCursor.moveToNext());
                    }
                }

                sourceCursor.close();

                for (int j = 0; j < ArrayDest.length; j++) {

                    Cursor destCursor = myDB.rawQuery("SELECT * FROM '" + ArrayDest.get(j) + "';", null);

                    if (destCursor != null) {
                        if (destCursor.moveToFirst()) {
                            do {
                                String b = destCursor.getString(0);
                                secondList.add(b);
                            } while (destCursor.moveToNext());
                        }
                    }
                    destCursor.close();

                    for (String one : firstList) {
                        for (int k = 0; k < secondList.size(); k++) {
                            String two = secondList.get(k);
                            if (one.equals(two)) {
                                //make your logic here
                            }
                        }
                    }
                }
            }