@Override
protected Boolean doInBackground(FilesObject... files) {
// getting an input Stream.
HttpResponse resp = service.getRequestFactory()
        .buildGetRequest(new GenericUrl(file.SourceImageUrl)).execute();
fileSize = resp.getHeaders().getContentLength();
if (fileSize != -1) {
    fileSizeReadableString = DiskSpaceUtil.readableFileSize(fileSize);
}
InputStream is = resp.getContent();

// publishing the progress in a dialog.
int completed = 0;
while ((length = inputStream.read(buffer)) > 0) {
    if (!this.isCancelled()) {
        completed += length;
        fOutputStream.write(buffer, 0, length);
        publishProgress(completed);
    } else {
        fOutputStream.flush();
        fOutputStream.close();
        inputStream.close();
        return;
    }
}

@Override
protected void onProgressUpdate(Integer... values) {

    sendShowloader("Downloading file ... \n"
            + DiskSpaceUtil.readableFileSize(number) + " of "
            + fileSizeReadableString);

}