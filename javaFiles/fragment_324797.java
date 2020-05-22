// your logic....
   Connection con = getConnection();
   // reading file logic
   while (it.hasNext()) {
        String line = it.nextLine();
        // do something with line
        insertValues(con, line);
        // other logic
   }
   // checking exception etc
   } finally {
        if (inputStream != null) {
            inputStream.close();
        }
        if (sc != null) {
            sc.close();
        }

        if (con != null ) {
            con.close();
        }

    }