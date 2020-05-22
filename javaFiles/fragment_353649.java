int fileNo = 0;
for (FTPFile file : files) {
    File serverFile = new File("D:/Pondi_" + fileNo + ".xlsx");
    ...
    InputStream in = client.retrieveFileStream("/Ftp1/"+ file.getName());
    OutputStream out = new FileOutputStream(serverFile);

    // read and copy binary data
    byte[] buf = new byte[1024];
    int len;
    while ((len = in.read(buf)) > 0){
        out.write(buf, 0, len);
    }

    in.close();
    out.close();
    fileNo++;
}