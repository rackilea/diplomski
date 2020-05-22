while (line !="table_end"){      
       for (line = bufferedReader.readLine(); line != null; 
                    line = bufferedReader.readLine()) { 
           if ( !line.equals("table_end"){
               //Do other things here
           }
    }
  }