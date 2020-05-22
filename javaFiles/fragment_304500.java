Part filePart = request.getPart("csvFile");
String path = mainPath + "/" + filePart.getSubmittedFileName();
File fileTemp = new File(path);
if(fileTemp.exists()){
    fileTemp.delete();
}