public byte[] readImage(Entity entity String filename) throws Exception {

    byte[]  imageData = null;
    try ( FileInputStream file : file = new FileInputStream(filename) ){

        int size = file.available();
        imageData = new byte[size];
        file.read(imageData);
        return imageData;
    } catch (IOException | FileNotFoundException e) {
        throw e;
    } 
}