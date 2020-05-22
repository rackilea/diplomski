// XXX Notice the slash before "res"
final static String IMAGE_RESOURCE_PATH = "/res/images";

...

String directoryPath = 
        getServletContext().getRealPath(IMAGE_RESOURCE_PATH + "/" + productId)
File directory = new File(directoryPath);

if(!directory.exists()) {
    directory.mkdirs();
}