Path dataset = new Path(fs.getHomeDirectory(), <path-to-file>);
  FileStatus datasetFile = fs.getFileStatus(dataset);

  BlockLocation myBlocks [] = fs.getFileBlockLocations(datasetFile,0,datasetFile.getLen());
  for(BlockLocation b : myBlocks){
    System.out.println("Length "+b.getLength());
    for(String host : b.getHosts()){
      System.out.println("host "+host);
    }
  }