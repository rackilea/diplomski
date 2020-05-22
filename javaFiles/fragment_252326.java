// Process the uploaded items

Iterator iter = items.iterator();

while (iter.hasNext()) {

  FileItem item = (FileItem) iter.next();

  if (item.isFormField()) {

    processFormField(item);
  } else {

    processUploadedFile(item);
  }
}