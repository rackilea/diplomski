for(FileContainerBean fileContainer:fileContainerList){
    FileUpload fileUpload=new FileUpload(fileContainer.getFile());
    fileUpload.run();

    // continues after the file is uploaded
}