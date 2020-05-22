/**
 * Count lines in a text files. Blank lines will not be counted.
 * @param f the file to count lines in.
 * @return the number of lines of the text file, minus the blank lines.
 * @throws FileNotFoundException if f can't be found.
 * @throws IOException if something bad happens while reading the file or closing it.
 */
public int countLinesInFile(File f) throws FileNotFoundException, IOException {
    BufferedReader reader = null;
    int lines = 0;
    int blankLines = 0;
    try {
            reader = new BufferedReader(new FileReader(f));

            String lineRead = "";
            while ( lineRead != null ){
               lineRead = reader.readLine();
               //on newer JDK, use lineRead.isEmpty() instead of equals( "" )
               if( lineRead != null && lineRead.trim().equals( "" ) ) {
                  blankLines ++;
               }//if 
               lines++;    
            }//while
    } finally {
       if( reader != null ) {
          reader.close();
       }//if
    }//fin
    return lines - blankLines;
}//met