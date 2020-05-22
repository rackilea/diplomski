public class Nextstud implements ActionListener {
    private DBCursor curs;
    public Nextstud() {
        Mongo s = new Mongo();
        DB db = s.getDB( "omrs1" );
        DBCollection coll = db.getCollection("Student") ;

        curs = coll.find();
    }

    public void actionPerformed(ActionEvent e) {
        try {
            if(curs.hasNext()) {
                DBObject o = curs.next();
                String fname = (String) o.get("Firstname") ; 
                String lname = (String) o.get("Lastname") ; 
                String sid = (String) o.get("StudentID") ; 
                String prg = (String) o.get("Programme") ;
                String lvl = (String) o.get("Level") ;

                txtfname.setText(fname) ; 
            }

            btndelstud.setEnabled(true); 
            btnbkstud.setEnabled(true) ;
            btnfwdstud.setEnabled(true);
        } catch (UnknownHostException x) {
            x.printStackTrace();
        } catch (MongoException x) {
            x.printStackTrace();
        }
    }
} // end class