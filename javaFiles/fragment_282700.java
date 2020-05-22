public void addPageMeta(PageMeta pageMeta) throws SAXException,
            WingException, UIException, SQLException, IOException,
            AuthorizeException
    {       
        pageMeta.addMetadata("javascript", "static", null, true).addContent("static/js/feedbackform.js");
        // leave the rest
        ...
    }