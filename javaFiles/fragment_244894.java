// Write to .jks file
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new FileWriter(newSnKeyStoreFile));
            out.write(keyStore.toString());
        } catch ( Exception e ) {
            e.printStackTrace();
        } finally {
            if ( out != null ) out.close();
        }