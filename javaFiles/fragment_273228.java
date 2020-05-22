public static int folderNumber( int fileNumber ) {
      int folderNum = (fileNumber-1) / 250 * 250;
      if( folderNum > 1000 ) folderNum++;
      if( folderNum < 1000 ) folderNum = 1000;
      return folderNum;
  }

  public static void main( String[] args )
  {
      for( int i = 1000; i < 3000; i += 250 ) {
         System.out.println( (i-1) + " -> " + folderNumber( i-1 ) );
         System.out.println( i + " -> " + folderNumber( i ) );
         System.out.println( (i+1) + " -> " + folderNumber( i+1 ) );

      }
   }