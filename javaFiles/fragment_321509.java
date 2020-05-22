{ // ... Inside some thread

    java.io.File fil = new java.io.File(file.SourceImageUrl);
    InputStream is = new FileInputStream(fil);

    InputStreamContent mediaContent = new InputStreamContent(file.mimeType, is);
            mediaContent.setLength(fil.length());

    // File's metadata.
    File body = new File();
    body.setTitle(file.FileTitle);
    body.setMimeType(file.mimeType);
    body.setParents(parents);
    body.setDescription("Content Uploaded to "+ DriveName);
    // Inserting the Remote Resource into Google Drive
    File destFile = null;

    if(fil.length() > 5 * 1024 * 1024)
    {
        // Resumable Uploads when the file size exceeds a file size of 5 MB.
        // check link : 
        // 1) https://code.google.com/p/google-api-java-client/source/browse/drive-cmdline-sample/src/main/java/com/google/api/services/samples/drive/cmdline/DriveSample.java?repo=samples&r=08555cd2a27be66dc97505e15c60853f47d84b5a
        // 2) http://stackoverflow.com/questions/15970423/uploading-downloading-of-large-size-file-to-google-drive-giving-error

        Insert insert = mService.files().insert(body, mediaContent);
        MediaHttpUploader uploader = insert.getMediaHttpUploader();
        uploader.setDirectUploadEnabled(false);
        uploader.setProgressListener(new FileUploadProgressListener());
        destFile = insert.execute();

    }   
    else
    {
        // Else we go by Non Resumable Uploads, which is safe for small uploads.
        destFile = mService.files().insert(body, mediaContent).execute();
    }

    ... }

    // Now the implementation of FileUploadProgressListener which extends MediaHttpUploaderProgressListener

public static class FileUploadProgressListener implements MediaHttpUploaderProgressListener {

    public void progressChanged(MediaHttpUploader uploader) throws IOException {
      switch (uploader.getUploadState()) {
        case INITIATION_STARTED:
          postToDialog("Initiation Started");
          break;
        case INITIATION_COMPLETE:
          postToDialog("Initiation Completed");
          break;
        case MEDIA_IN_PROGRESS:
          // postToDialog("Upload in progress");
          postToDialog("Upload percentage: " + uploader.getProgress());
          break;
        case MEDIA_COMPLETE:
          postToDialog("Upload Completed!");
          break;

        case NOT_STARTED :
            postToDialog("Not Started!");
            break;
      }
    }
  }