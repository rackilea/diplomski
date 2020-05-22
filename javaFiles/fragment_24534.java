int blankLines = 0;
 String lineRead = "";
 while ( lineRead != null ){
       lineRead = reader.readLine();
       //on newer JDK, use lineRead.isEmpty() instead of equals( "" )
       if( lineRead != null && lineRead.trim().equals( "" ) ) {
        blankLines ++;
       }//if 
       lines++;    
 }//while

 int totalLineCount = lines - blankLines;