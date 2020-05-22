public class TransferObject {

    public long tid;
    public String tname;
    public String tlastname;
    public String tmessage;

    Message mess = new Message(tmessage);
    Person pers = new Person(tid,tname,tlastname);

    public Person getPerson() {     
        return pers;
    }

    public Message getMessage() {
        return mess;
    }
}