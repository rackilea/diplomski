private class MyNetworkTask extends AsyncTask<Void, Void, Void> {
     protected Boolean doInBackground()  {

        try {
        st = xyz.createStatement();
        rs = st.executeQuery("SELECT name from lalit_db where category='.Net'");

        while(rs.next())
        {
            Log.w("Here is the result..", rs.getString(1));
        }


    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
return false;
    }
return true;
}

     protected void onProgressUpdate(Integer... progress) {
        
     }

     protected void onPostExecute(Long result) {
          Log.w(“Process completed”);
     }
 }