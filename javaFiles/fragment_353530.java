streamResource = createStreamResource();
downloadButton createDownloadButton();
downloadButton.setId("DownloadButtonID");

if(fileDownloader == null)
{
    fileDownloader = new FileDownloader(streamResource);
    fileDownloader.extend(downloadButton);
    // Javascript click so that it works without a second click
    Page.getCurrent().getJavaScript().execute(
           "document.getElementById('DownloadButtonID').click();");
} else {
    fileDownloader.setFileDownloadResource(streamResource);
}