@RequestMapping(value = "/files/{job}", method = RequestMethod.GET, produces=MediaType.APPLICATION_OCTET_STREAM_VALUE)
public void downloadFile(@PathVariable("job") String job, HttpServletResponse response) {

//Configure the input stream from the job
    InputStream file = new FileInputStream(fileStoragePath + "\\" + job);

    response.setHeader("Content-Disposition", "attachment; filename=\""+job+"\"");


    int readBytes = 0;
    byte[] toDownload = new byte[100];
    OutputStream downloadStream = response.getOutputStream();

    while((readBytes = file.read(toDownload))!= -1){
        downloadStream.write(toDownload, 0, readBytes);
    }
    downloadStream.flush();
    downloadStream.close(); 
}