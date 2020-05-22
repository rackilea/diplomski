FileInputStream fis = new FileInputStream(this.filepath);
  InflaterInputStream inStream = new InflaterInputStream(fis);
  int i = -1;
  while((i = inStream.read()) != 0){
      //First line
  }

  //Content data
  while((i = inStream.read()) != -1){
    while((i = inStream.read()) != 0x20){ //0x20 is the space char
      //Permission bytes
    }

    //Filename: 0-terminated
    String filename = "";
    while((i = inStream.read()) != 0){
      filename += (char) i;
    }

    //Hash: 20 byte long, can contain any value, the only way
    // to be sure is to count the bytes
    String hash = "";
    for(int count = 0; count < 20 ; count++){
      i = inStream.read();
      hash += Integer.toHexString(i);
    }
  }