String encodedBase64=jsonob.optString("pdf bytearray");

     byte[] decodedBytes = Base64.decodeBase64(encodedBase64);
     System.out.println("decbyte   "+decodedBytes);
     File someFile = new File("C:/Users/acer/Desktop/test.pdf");
     OutputStream fos = new FileOutputStream(someFile);
     fos.write(decodedBytes);
     fos.flush();
     fos.close();