while ((currentLine = insertReader.readLine()) != null) {
                            if (currentLine.length() != 0) {
                                if (currentLine.charAt(currentLine.length() - 1) == ';') {
                                    insertInDb(db, insertStr + "\n" + currentLine);
                                    insertStr = "";
                                } else {
                                    insertStr += currentLine;
                                }
                            }
                        }




 private int insertFromFile(SQLiteDatabase db, String assetFilePath, int totalCount) {
            int result = 0;
            BufferedReader insertReader = null;
            try {
                InputStream insertStream = context.getAssets().open(assetFilePath);
                insertReader = new BufferedReader(new InputStreamReader(insertStream));

                db.beginTransaction();

                while (insertReader.ready()) {

                    // String insertStr = insertReader.toString();

                    String insertStr = "";
                    String currentLine;
                    while ((currentLine = insertReader.readLine()) != null) {
                        if (currentLine.length() != 0) {
                            if (currentLine.charAt(currentLine.length() - 1) == ';') {
                                insertInDb(db, insertStr + "\n" + currentLine);
                                insertStr = "";
                            } else {
                                insertStr += currentLine;
                            }
                        }
                    }

                }
                db.setTransactionSuccessful();

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (insertReader != null) {
                    try {
                        insertReader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                db.endTransaction();
            }

            return result;
        }

        private void insertInDb(SQLiteDatabase db, String assetFilePath) throws IOException {
            if (assetFilePath != null && assetFilePath.length() > 0) {
                SQLiteStatement statement = db.compileStatement(assetFilePath);
                statement.execute();

            }

        }