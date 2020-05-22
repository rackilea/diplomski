BASE64Decoder decoder = new BASE64Decoder();
    byte[] image = decoder.decodeBuffer(string);
    String fileLocation  = "C:\temp";
    String fileName = "New-" + System.currentTimeMillis();
    File file = new File(fileLocation +File.separator+ fileName + ".svg");
    FileOutputStream fop = new FileOutputStream(file);
    if (!file.exists()) {
      file.createNewFile();
    }
    fop.write(image);
    fop.flush();
    fop.close();
    PNGTranscoder transcoder = new PNGTranscoder();
    TranscoderInput tinput = new TranscoderInput(new FileInputStream(fileLocation + File.separator + fileName +".svg"));
    OutputStream ostream = new FileOutputStream(fileLocation + File.separator + fileName +".png");
    TranscoderOutput toutput = new TranscoderOutput(ostream);
    try {
          transcoder.transcode(tinput, toutput);
    } catch (TranscoderException e) { 
          System.out.println("error*");
           e.printStackTrace();
    }
    ostream.close();