final ZipFile file = new ZipFile(filePath);
       final Enumeration<? extends ZipEntry> entries = file.entries();
       while ( entries.hasMoreElements() ) {
           final ZipEntry zipEntry = entries.nextElement();
           // code to generate the json file tree ---
           // --- end of code
       }
   }