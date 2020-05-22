File file=new File(getExternalFilesDir(null),"Dummy");
/*
Create a DownloadManager.Request with all the information necessary to start the download
*/
DownloadManager.Request request = 
    new DownloadManager.Request(Uri.parse("YOUR URL"))
       .setTitle("Dummy File")// Title of the Download Notification
       .setDescription("Downloading")// Description of the Download Notification
       .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)// Visibility of the download Notification
       .setDestinationUri(Uri.fromFile(file))// Uri of the destination file
       .setRequiresCharging(false)// Set if charging is required to begin the download
       .setAllowedOverMetered(true)// Set if download is allowed on Mobile network
       .setAllowedOverRoaming(true);// Set if download is allowed on roaming network