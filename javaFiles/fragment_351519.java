public class Server extends Computer{

     public Vector<Ethernet> etherPort = new Vector<Ethernet>(); 

     public void addPort(Ethernet t)
     {
        this.etherPort.addElement(t);
     }
}