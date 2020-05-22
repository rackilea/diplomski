/**
 * Embeds an image into the document and gets back the new URL.
 *
 * @param factory Factory interface of the document.
 * @param file Image file.
 * @param internalName Name of the image used inside the document.
 * @return URL of the embedded image.
 */
public static String embedLocalImage(XMultiServiceFactory factory, File localFile, String internalName) {

    // future return value
    String newURL = null;

    // URL of the file (note that BitmapTable expects URLs starting with
    // "file://" rather than just "file:". Also note that getRawPath() will
    // return an encoded URL (with special character in the form of %xx).
    String imageURL = "file://" + localFile.toURI().getRawPath();

    try {

        // get a BitmapTable object from the document (and get interface)
        Object bitmapTable = factory.createInstance("com.sun.star.drawing.BitmapTable");
        XNameContainer bitmapContainer = (XNameContainer)UnoRuntime.queryInterface(XNameContainer.class, bitmapTable);

        // insert image by URL into the table
        bitmapContainer.insertByName(internalName, imageURL);

        // get interface
        XNameAccess bitmapAccess = (XNameAccess)UnoRuntime.queryInterface(XNameAccess.class, bitmapTable);

        // get the embedded URL back
        newURL = (String)bitmapAccess.getByName(internalName);

    } catch (Exception e) {
        throw new RuntimeException(e);
    }

    // return the new (embedded) url
    return newURL;
}