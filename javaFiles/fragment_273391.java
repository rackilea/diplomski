class CustomProgressListener implements MediaHttpDownloaderProgressListener {
  public void progressChanged(MediaHttpDownloader downloader) {
    switch (downloader.getDownloadState()) {
      case MEDIA_IN_PROGRESS:
        System.out.println(downloader.getProgress());
        break;
      case MEDIA_COMPLETE:
        System.out.println("Download is complete!");
    }
  }
}

OutputStream out = new FileOutputStream("/tmp/driveFile.jpg");

DriveFiles.Get request = drive.files().get(fileId);
request.getMediaHttpDownloader().setProgressListener(new CustomProgressListener());
request.executeMediaAndDownloadTo(out);