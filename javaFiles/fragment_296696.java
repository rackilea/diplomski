Message message = exchange.getIn();
    if (message.getAttachments().size() > 0) {
        for (Map.Entry<String, DataHandler> entry : messageCopy.getAttachments().entrySet()) {
            DataHandler dataHandler = entry.getValue();
            //get the document filename                
            String attchmentFilename = dataHandler.getName();
            String decodedFilename = MimeUtility.decodeText(attchmentFilename);
            //get inputstream of attachment file
            InputStream is = dataHandler.getInputStream();              
            //generic function for extracting attachment content
            extractor(is);
        }
    }