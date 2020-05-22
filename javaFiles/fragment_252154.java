foreach(Entry entry: comicFileMap.entryset()){
  sysout(entry.getKey()); // this will be your comicName

  foreach(Entry entryChild: entry.getValue()){ //the getValue() will be again 
                                               //hashmap()
     sysout(entrychild.getkey());
     foreach(String str: entryChild.getValue()){//this loop will print list of 
                                                //string
       sysout(str); 
     }
  }
}