public static List<Highscore> readHighScoreTable(String fileName) throws IOEexception {
    //creates a new ArrayList of highscores.
    List<Highscore> result = new ArrayList<Highscore>();    

    //creates a new bufferedReader that reads from the file. 
    try (BufferedReader reader = new BufferedReader(new FileReader(fileName))){
      String line = null;
      //a loop that reads through all the lines in the file.
      while((line = reader.readLine()) != null) {
        //some code 
      }
    }   
    return result;
}