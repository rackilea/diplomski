int numberOfFileWriters = 10;
  FileWriter fWriter[];
  fWriter = new FileWriter[numberOfFileWriters];
  try{
     //using first fileWriter
     fWriter[0] = new FileWriter(file, true);
     fWriter[0].write("content");
     fWriter[0].flush();

  }catch(Exception e){
      e.printStackTrace();
  }finally{
     fWriter[0].close();
  }

  //Similarly you can use other fWriters in array using their index like fWriter[i]