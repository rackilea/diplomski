HttpClient httpClient = ...;

 // the output for the image data
 OutputStreamContentProvider content = new OutputStreamContentProvider();
 MultiPartContentProvider multiPart = new MultiPartContentProvider();
 multiPart.addFilePart("attached_media", "img.png", content, null);
 multiPart.close();
 // Use try-with-resources to autoclose the output stream
 try (OutputStream output = content.getOutputStream())
 {
     httpClient.newRequest("localhost", 8080)
             .content(multipart)
             .send(new Response.CompleteListener()
             {
                 @Override
                 public void onComplete(Result result)
                 {
                     // Your logic here
                 }
             });

     // At a later time...
     ImageIO.write(image, "png", output);
 }