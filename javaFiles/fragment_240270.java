@Action(value = "sample-export", results = { @Result(name = "success", type = "stream", params = {
            "inputName", "inputStream", 
            "contentType",   "${exportContentType}; charset=UTF-8", 
            "Content-Disposition", "attachment; filename=\"${filename}\"", 
            "contentDisposition","attachment; filename=\"${filename}\"", 
            "bufferSize", "2048" }) })
    public String export() throws ClientException {

        inputStream = exportInputStream();

        return SUCCESS;

    }
    //Setter and getters for inputStream (java.io.InputStream)