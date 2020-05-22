class LookUpThread implements Runnable {
String name;
public LookUpThread() {

}

public LookUpThread(String Name) {
    this.name = Name;
}

public void run() 
{
    try 
    {
        InetAddress address = InetAddress.getByName(this.name);
        System.out.println(address.getHostAddress());
    } 
    catch (Exception E) {
        System.out.println("Exception " + E.getMessage());
    }
}