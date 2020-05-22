String filenameOfUploadedFile = getItSomehow();

if (isAlreadyUploaded(filenameOfUploadedFile)) {
    request.setAttribute("message", "Error, the file is already uploaded!");
}
else {
    // Process.
    // ...

    request.setAttribute("message", "File upload is successfully processed!");
}