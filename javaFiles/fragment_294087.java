public static void saveImageToDisk(String filename, String fileext, String uri) {
    try {
        String[] components = uri.split(",");
        String img64 = components[1];
        byte[] decodedBytes = DatatypeConverter.parseBase64Binary(img64);
        File outputfile = new File(IMAGESTORAGEFOLDER, filename + "." + fileext);
        Paths.write(outputFile.toPath(), decodedBytes);
    } catch(Exception e) {  
        // You really shouldn't swallow this exception, but I'll leave that to you...
        e.printStackTrace(); 
    }
}