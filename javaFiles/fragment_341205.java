List<GameRecord> grList = new ArrayList<GameRecord>();
bufferedReader = new java.io.BufferedReader(fileReader); 
while ((sCurrentLine = bufferedReader.readLine()) != null){
    parts = sCurrentLine.split("\t");
    GameRecord gameRecord = new GameRecord(parts[0],
                                           Integer.parseInt(parts[1]),
                                           Integer.parseInt(parts[2]));
    grList.add(gameRecord);  // add the GameRecord object to the ArrayList
                             // and let the JVM worry about sizing problems
}

// finally, convert the ArrayList to an array
GameRecord[] grArray = new String[grList.size()];
grArray = grList.toArray(grArray);