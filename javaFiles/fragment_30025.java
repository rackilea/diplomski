ZipFile ifile = new ZipFile(inFileName);
        // faster to loop through entries than open the zip file as a stream
        Enumeration<? extends ZipEntry> entries = ifile.entries();  

        while ( entries.hasMoreElements()) {
            ZipEntry entry = entries.nextElement();
            if (!entry.isDirectory()) {  // skip directories
                String entryName = entry.getName();
                // code to determine to process omitted
                InputStream zis = ifile.getInputStream(entry); 
                // process the stream
            }
        }