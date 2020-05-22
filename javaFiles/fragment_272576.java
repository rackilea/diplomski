@Get("/getImage/{path}")     
public void getImage(String path) {

    // path is in based16/Base64 encoding

    String pathOfImage = functionToConvertEncodedPathToRealPath ( path)

}