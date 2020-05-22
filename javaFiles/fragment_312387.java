public class maintest {


    public static void main(String args[]) throws FileNotFoundException{

        XStream xstream = new XStream(); 
        xstream.alias("SenderData", Account.class);
        FileReader r = new FileReader("sender.xml");
        Account sender=(Account)xstream.fromXML(r);     
        sender.toPtring();


        xstream.alias("RecipientData", Account.class);
        FileReader r2 = new FileReader("recipient.xml");
        Account recipient=(Account)xstream.fromXML(r2);
        recipient.toPtring();


    }
}