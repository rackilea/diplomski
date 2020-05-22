package com.javacodegeeks.core.rmi.rminterface;

public class Configuration {

    public static final int REMOTE_PORT = 8888;
    public static final String REMOTE_ID = "RMI_EXAMPLE";
    public static final String REMOTE_HOST = "localhost";

}


package com.javacodegeeks.core.rmi.remoteserver;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import com.javacodegeeks.core.rmi.rminterface.Configuration;

public class RemoteServer {

    public static void main(String[] args) throws RemoteException, AlreadyBoundException {

        RMIImplementation rmiImplementation = new RMIImplementation();
        Registry registry = LocateRegistry.createRegistry(Configuration.REMOTE_PORT);
        registry.bind(Configuration.REMOTE_ID, rmiImplementation);
    }
}