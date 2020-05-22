private static String DB_PATH = "/data/data/com.demo.databaseDemo/databases/";
 private static String DB_NAME = "myDatabase.db";   
 private void copyDataBase() throws IOException{

            //Open your local db as the input stream
            InputStream myInput = _myContext.getAssets().open(DB_NAME);

            // Path to the just created empty db
            String outFileName = DB_PATH + DB_NAME;

            //Open the empty db as the output stream
            OutputStream myOutput = new FileOutputStream(outFileName);

            //transfer bytes from the inputfile to the outputfile
            byte[] buffer = new byte[1024];
            int length;
            while ((length = myInput.read(buffer))>0){
                myOutput.write(buffer, 0, length);
            }

            //Close the streams
            myOutput.flush();
            myOutput.close();
            myInput.close();

        }//end of copyDataBase() method