File attachFiles[] = ...

if (attachFiles > 0) {
    //attach file
    attachFile(attachFiles[0], multipart, messageBodyPart);
    if (attachFiles > 1) {
        for (int index = 1; index < attachFiles.length; index++) {
            attachFile(attachFiles[0], multipart, new MimeBodyPart());
        }
    }
}