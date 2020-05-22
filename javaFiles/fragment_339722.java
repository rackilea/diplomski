Resource xmlFile = new ByteArrayResource(stringWithXMLcontent.getBytes("UTF-8")){
            @Override
            public String getFilename(){
                return documentName;
            }
        };
        HttpHeaders xmlHeaders = new HttpHeaders();
        xmlHeaders.setContentType(MediaType.APPLICATION_XML);
        HttpEntity<Resource> xmlEntity = new HttpEntity<Resource>(xmlFile, xmlHeaders);
        parts.add("attachment", xmlEntity);