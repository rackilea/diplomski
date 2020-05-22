public void readCSVFromRawResource(Context context)
{
    //this requires there to be a dictionary.csv file in the raw directory
    //in this case you can swap in whatever you want
    InputStream inputStream = getResources().openRawResource(R.raw.dictionary);
    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

    try
    {
       String word;//word
       int primaryKey = 0;//primary key
       Map dictionaryHash = new HashMap();

       while ((word = reader.readLine()) != null)
       {
           if(word.length() < 7)
           {
               dictionaryHash.put(primaryKey,word );
               primaryKey++;



               if(primaryKey % 1000 == 0)
                   Log.v("Percent load completed ", " " + primaryKey);
           }
       }

        //write the dictionary to a file
        File file = new File(DICTIONARY_FILE_NAME);
        BufferedOutputStream fos = new BufferedOutputStream(new FileOutputStream(DICTIONARY_FILE_NAME));
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(dictionaryHash);
        oos.flush();
        oos.close();
                 Log.v("alldone","done");

   }
   catch (Exception ex) {
       // handle exception
       Log.v(ex.getMessage(), "message");
   }
   finally
    {
       try
       {
           inputStream.close();

       }
       catch (IOException e) {
           // handle exception
          Log.v(e.getMessage(), "message");
       }
   }
}