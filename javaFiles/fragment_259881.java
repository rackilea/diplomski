@Override
public String createImage(String origFilename) {

    BlobKey blobKey = null;
    String modifiedURL=null;
    try {
          // Get a file service
          FileService fileService = FileServiceFactory.getFileService();

          // Create a new Blob file with mime-type "image/png"
          AppEngineFile file1 = fileService.createNewBlobFile("image/png");


          boolean lock = true;// This time lock because we intend to finalize

        // Open a channel to write to it
          FileWriteChannel writeChannel = fileService.openWriteChannel(file1, lock);
          OutputStream os = Channels.newOutputStream(writeChannel);

         //Fetching image from URL

          URL url = new URL(escapeHTML(origFilename));      //escape Special Characters     
          PngReader pngr     = new PngReader(url.openStream());

          //Create PngWriter to write to Output Stream
          PngWriter pngw = new PngWriter(os, pngr.imgInfo);

          //Modify the image

            int channels = pngr.imgInfo.channels;

            if(channels<3) throw new RuntimeException("Only for truecolour images");
            for (int row = 0; row < pngr.imgInfo.rows; row++) {
                ImageLine l1 = pngr.readRow(row);
                for(int j=0;j<pngr.imgInfo.cols;j++)
                    l1.scanline[j*channels]=250; // Change the color of the pixel
                pngw.writeRow(l1); //write rows
            }


            // Now finalize
            pngr.end();
            pngw.end();
            os.close(); // close the output stream  

            writeChannel.closeFinally();


            //Get the BlobKey
           blobKey= fileService.getBlobKey(file1);

           /*Using ImageService to retrieve Modified Image URL
           http://code.google.com/appengine/docs/java/images/overview.html
           */
           ImagesService imagesService = ImagesServiceFactory.getImagesService();
           modifiedURL= imagesService.getServingUrl(blobKey);





    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

    return  modifiedURL;

}

//This is the function to escape special characters
 public static final String escapeHTML(String s) {
     StringBuffer sb = new StringBuffer();
     int n = s.length();
     for (int i = 0; i < n; i++) {
       char c = s.charAt(i);
       switch (c) {
       case '|':
         sb.append("%7C");
         break;
       case ' ':
         sb.append("%20");
         break;

       default:
         sb.append(c);
         break;
       }
     }
     return sb.toString();
   }