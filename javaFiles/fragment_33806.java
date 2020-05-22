String aaaa;
public DatabaseSearch(){

FileHandle h = new FileHandle();
    try {    
        h.openFile();
    } catch (FileNotFoundException ex) {
        Logger.getLogger(DatabaseSearch.class.getName()).log(Level.SEVERE, null, ex);
    }
 pirmas = h.a;
 System.out.println(pirmas+"cia");
}