import java.rmi.*;
import java.rmi.registry.*;
import java.io.*;


public class RMIServer{

  public static void main(String[] argv) throws Exception{

    StackImp s = new StackImp(10);
    Registry reg = LocateRegistry.createRegistry(2000);
    reg.rebind("xyz", s);
    System.out.println("RMI Server ready....");
    System.out.println("Waiting for Request...");   

  }
}