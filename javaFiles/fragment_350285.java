try {

        File f = new File("c:\java\test.docx");
        InputStream is = new FileInputStream(f);
        byte[] inbuff = new byte[(int)f.length()];        
        is.read(inbuff);

        Attachment attach = new Attachment();
        attach.setBody(inbuff);
        attach.setName("test.docx");
        attach.setIsPrivate(false);
        // attach to an object in SFDC 
        attach.setParentId("a0f600000008Q4f");

        SaveResult sr = binding.create(new com.sforce.soap.enterprise.sobject.SObject[] {attach})[0];
        if (sr.isSuccess()) {
            System.out.println("Successfully added attachment.");
        } else {
            System.out.println("Error adding attachment: " + sr.getErrors(0).getMessage());
        }


    } catch (FileNotFoundException fnf) {
        System.out.println("File Not Found: " +fnf.getMessage());

    } catch (IOException io) {
        System.out.println("IO: " +io.getMessage());            
    }