FileInputStream fileInput = null;
try {
    fileInput = new FileInputStream(file);
    ftp.put(fileInput, file.getName(), ChannelSftp.OVERWRITE);
} catch (SftpException ex) {
    if (!ex.getMessage().equalsIgnoreCase("Permission denied"))
        throw ex;
}
finally{
 if(fileInput != null){
   fileInput.close();
 }
}