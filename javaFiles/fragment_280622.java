if (listener != null) 
   {
      listener.theMethod(result); // result is the ArrayList<String>
      // result returned in doInbackground 
      // result of doInbackground computation is a parameter to onPostExecute 
   }