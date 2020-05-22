BufferedReader textReader;
    while(flag==0){
      textReader = new BufferedReader(new FileReader(filename));
      textData=textReader.readLine();
      if(textData==null){
        Thread.sleep(3000);
        continue;
      }
      process(textData);
    }