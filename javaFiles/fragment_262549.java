if(server.getHar()==null){
        System.out.println("No Har capture");
    }
    Har har = server.getHar();
    if(har==null){
        System.out.println("Har is NULL");
    }

    FileOutputStream fos = new FileOutputStream(FILE_OUTPUT_HAR+"fos"+".har");
    har.writeTo(fos);



    HarLog log = har.getLog();
    if(log==null){
        System.out.println("Harlog is null");
    }
    List<HarEntry> entries = new CopyOnWriteArrayList<HarEntry>(log.getEntries());
            System.out.println("entries"+entries);
            for (HarEntry entry : entries){
                System.out.println("entry="+entry.getRequest().getUrl());
            }

    File harFile = new File(HAR_FILE_PATH+"2"+".har");
    File("/Users/yourpath/"+"2"+".har");        
    har.writeTo(harFile);