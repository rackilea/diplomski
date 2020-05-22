IModel fileModel = new AbstractReadOnlyModel(){
    public Object getObject() { 
        return generateFile();
    }
};

DownloadLink link = new DownloadLink(linkId, fileModel, "report.pdf");