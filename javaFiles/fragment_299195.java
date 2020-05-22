byte[] filebyte = new byte[length]
fis.read(filebyte);
byte[] tmpTxt = mDecipher.doFinal(filebyte);
fis.close();

String plaintxt = new String(tmpTxt, "UTF-8");