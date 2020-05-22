public class Demographic extends CustomComponent implements Upload.SucceededListener,Upload.FailedListener, Upload.Receiver,Upload.ProgressListener
{
    private Upload uploadPic;
     public Demographic()
     {
        mainLayout = new AbsoluteLayout();
        mainLayout.setImmediate(true);
        mainLayout.setWidth("100%");
        mainLayout.setHeight("100%");
        mainLayout.setMargin(false);

        uploadPic = new Upload("Upload image", this);
        uploadPic.setImmediate(true);
        uploadPic.setWidth("-1px");
        uploadPic.setHeight("-1px");                  
        mainLayout.addComponent(uploadPic, "top:135.0px;left:32.0px;");


        uploadPic.addListener((Upload.SucceededListener) this);
        uploadPic.addListener((Upload.FailedListener) this);          
        uploadPic.addListener((Upload.ProgressListener)this);
      }
      @Override
      public void uploadFailed(FailedEvent event) {
    // TODO Auto-generated method stub

        app.getMainWindow().showNotification("Error! <br />", "Upload Failed due           to: " + event.getReason().getMessage() ,             Window.Notification.TYPE_WARNING_MESSAGE);

      }
    @Override
    public void uploadSucceeded(SucceededEvent event) {
          // all success logic
          if(event.getMIMEType().contains("image")){//mimeType can be made a global variable and can set in Receive upload

        //  System.out.println(event.getFilename());

            savePicture(event.getFilename());// save pic to db from the path provided in receive upload


                app.getMainWindow().showNotification("Success! <br />", "Image upload successful!", Window.Notification.TYPE_TRAY_NOTIFICATION);
            }
        }
    }
    @Override
    public OutputStream receiveUpload(String filename, String mimeType) {
         FileOutputStream fos;

        if(mimeType.contains("image")){
          String basePath = getApplication().getContext().getBaseDirectory().getAbsolutePath() + "\\Documents\\"+filename;

          File file= new File(basePath);    
          boolean checkForDir = file.exists();

         if(!checkForDir){
         checkDir.mkdir();
          }
         try {
        // Open the file for writing.
            fos = new FileOutputStream(file);       
           } catch (final java.io.FileNotFoundException e) {

           // Error while opening the file. Not reported here.
                   //e.printStackTrace();

            return null;
         }

        }
        return fos;
    }
}