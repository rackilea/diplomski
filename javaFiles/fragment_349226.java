public void play() {
    try {
      File fileIn = new File(" ....);
      AudioInputStream audioInputStream=AudioSystem.getAudioInputStream(fileIn);
      AudioFormat formatIn=audioInputStream.getFormat();
      AudioFormat format=new AudioFormat(formatIn.getSampleRate()*2, formatIn.getSampleSizeInBits(), formatIn.getChannels(), true, formatIn.isBigEndian());
          System.out.println(formatIn.toString());
          System.out.println(format.toString());
      byte[] data=new byte[1024];
      DataLine.Info dinfo=new DataLine.Info(SourceDataLine.class, format);
      SourceDataLine line=(SourceDataLine)AudioSystem.getLine(dinfo);
      if(line!=null) {
        line.open(format);
        line.start();
        while(true) {
          int k=audioInputStream.read(data, 0, data.length);
          if(k<0) break;
          line.write(data, 0, k);
        }
        line.stop();
        line.close();
      }
    }
    catch(Exception ex) { ex.printStackTrace(); }
  }