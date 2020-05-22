function downloadFileToPath(remoteUrl, localPath, successHandler, errorHandler) {
    if (!masseyApp.isInBrowser()) {
        var fileTransfer = new FileTransfer();
        fileTransfer.download(remoteUrl, localPath, 
            function(metadata) {

            console.log("Successfully downloaded " + remoteUrl + " to " + localPath + ".");

            if (successHandler) {
                successHandler(metadata);
            }

            }, 
            function (e) {
                errorHandler(error.createError(ERROR_IO_ERROR, "IO Error", "Failed to download " + e.source + " to " + e.target + " - " + fileErrorToString(e)));
            }
        );
    }
}