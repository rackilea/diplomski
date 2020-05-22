for (String fId : fIds) {         
        String[] ftIds = handler.XMLList("//snip/ftid/text()");
        for (String ftId : ftIds) {  
            MyType tld = new MyType();
            tld.setFtId(ftId);
            tld.setFId(fId);        
            logger.info("ftId:"+ftId+",fId:"+fId);
            dataList.add(tld);  // each ft
        }
    }