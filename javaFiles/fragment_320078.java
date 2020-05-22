/**
     *  This function saves a VCard to disk.
     */
    public static void saveToFile( String fileName , VCard vcard) {
    Writer output = null;   
    File file = new File("fileName");   
    try {
        output = new BufferedWriter(new FileWriter(file));
        VCardWriter writer = new VCardWriter();
        writer.setVCard(vcard);
        output.write(writer.buildVCardString());  
        output.flush();  
        output.close(); 
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }   
    }