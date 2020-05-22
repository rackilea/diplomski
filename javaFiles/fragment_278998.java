while ((strLine = br.readLine()) != null)   {
    //Compare the line with the line to compare (string)
    if(strLine.trim().compareTo(lineToCompare) == 0) {
      //I found it!  Read the next line...
      final String lineAfter = br.readLine();
      return Integer.parseInt(lineAfter);    
    }
}