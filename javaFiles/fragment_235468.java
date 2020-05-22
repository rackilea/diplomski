BufferedImage image = msg.getImage();
byte[] imgBytes = ((DataBufferByte) image.getData().getDataBuffer()).getData();

// Using DataOutputStream for simplicity
DataOutputStream data = new DataOutputStream(out);

data.writeInt(image.getWidth());
data.writeInt(image.getHeight());
data.write(imgBytes);

data.flush();