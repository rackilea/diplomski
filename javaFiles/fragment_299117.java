package myweb;

 import java.rmi.RemoteException;

 import NET.webserviceX.www.AccelerationUnitSoap;
 import NET.webserviceX.www.AccelerationUnitSoapProxy;
 import NET.webserviceX.www.Accelerations;

 public class MyClass {

 public String getResult() throws RemoteException {
      AccelerationUnitSoap a = new AccelerationUnitSoapProxy();
      Accelerations x = Accelerations.decimeterPersquaresecond;
      Accelerations y = Accelerations.centimeterPersquaresecond;
      Object z = a.changeAccelerationUnit(1, x, y);
      return z.toString();
 }

 public static void main(String[] args) throws RemoteException {

      MyClass c = new MyClass();
      System.out.println(c.getResult());

 }

 }