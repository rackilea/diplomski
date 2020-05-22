private final JTable table ;

public test() {
    super();
    setBounds(100, 100, 781, 412);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    header=new Vector<String>();
    header.add("Imones pavadinimas");
    header.add("vardas");
    header.add("pavarde");
    header.add("salis");
    header.add("Adresas");
    header.add("telefonas");

    GtFromDb db=new GtFromDb();
    try {
        data=db.getClient();
    } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }  
    table = new JTable(data,header);    

    try {
        jbInit();
    } catch (Throwable e) {
        e.printStackTrace();
    }
}