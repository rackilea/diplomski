public void fillDB(){
        InputStreamReader in= new InputStreamReader(dataIS);
        BufferedReader dataBR= new BufferedReader(in);
        String dataLine;
        try {
        while ((dataLine = dataBR.readLine()) != null)   {
          // split the data line
          dataLineTokenizer = new StringTokenizer(dataLine, ":");
                //SQL query + save data to database
          String sql =  "INSERT INTO location ...";
          //execute query
          Log.v("Test Saving", sql);
          clubberDB.execSQL(sql);
        }
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
    }