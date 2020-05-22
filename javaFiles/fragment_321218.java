package arrayListRMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;


public class ArrayListImpl  extends UnicastRemoteObject implements IArrayList{

    private static final long serialVersionUID = 1L;
    private ArrayList<String> text;

    protected ArrayListImpl() throws RemoteException {
        super();
    }

    public ArrayList<String> getText() {
        return text;
    }

    public void setText(ArrayList<String> text) {
        this.text = text;
    }

}