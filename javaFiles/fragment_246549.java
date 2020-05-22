package shared;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;
  public interface Start extends Remote{
  public void startRMI(Map<Object,Object> m) throws RemoteException;
  public void stopRMI() throws RemoteException;
}