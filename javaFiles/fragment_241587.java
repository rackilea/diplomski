public class HelloWorld{
Scanner keyboard = new Scanner(System.in);



public static void main(String[] args) throws Exception {

    List<Client> clientList = new ArrayList<Client>();
    Client c1 = new Client("V1");
    Client c2 = new Client("V2");
    Client c3 = new Client("V3");
    Client c4 = new Client("V4");

    clientList.add(c1);
    clientList.add(c2);
    clientList.add(c3);
    clientList.add(c4);

    HelloWorld h = new HelloWorld();
    h.addTelephone(clientList);

    Client cTest = clientList.get(2);
    System.out.println(cTest.getTelephoneNumber());





}
public void addTelephone(List<Client> clientList)
{
    System.out.print("What is the name of the new client?: ");
    String name = keyboard.nextLine();
    Client c = new Client(name);
    if(clientList.contains(c))
    {//Client Already Exist
        int i =  clientList.indexOf(c);
        Client c1 = clientList.get(i);
        List<String> telNumber = new ArrayList<String>();
        getTelephoneNumbers(telNumber);
        c1.setTelephoneNumber(telNumber);
    }

}
}
public  void getTelephoneNumbers(List<String> telephone)
{
    boolean isExit = false;

    while(!isExit)
    {
        System.out.println("Enter Telephone Number  or 0 for exiting : ");
        String telp = keyboard.nextLine();
        if("0".equalsIgnoreCase(telp)) {
            System.out.println("Exiting");
            isExit = true;
        }
        else {
            telephone.add(telp);
        }
    }
}