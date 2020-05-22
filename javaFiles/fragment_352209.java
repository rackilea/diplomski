public byte[] imageProcessing(String imageName, Image image) {

        int[] rgb = image.getRGB();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);
        dos.writeUTF(imageName);

        for (int i = 0; i < rgb.length; i++) {
            dos.writeInt(rgb[i]);
        }

   return baos.toByteArray();
 }