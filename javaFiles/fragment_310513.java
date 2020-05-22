ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
  try {
    byte[] data=new byte[1024];
    while(true) {
      k=audioInputStream.read(data, 0, data.length);
      if(k<0) break;
      outputStream.write(data, 0, k);
    }
    AudioFormat af=new AudioFormat(8000f, 16, 1, true, false);
    byte[] audioData=outputStream.toByteArray();
    InputStream byteArrayInputStream=new ByteArrayInputStream(audioData);
    AudioInputStream audioInputStream2=new AudioInputStream(byteArrayInputStream, af, audioData.length/af.getFrameSize());
    outputStream.close();
  }
  catch(Exception ex) { ex.printStackTrace(); }
}