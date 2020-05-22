package com.simplecalc.server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import com.simplecalc.commons.Calculator;

public class Server {

    public static void main(String[] args) throws RemoteException {
        final int port = 1099;
        final String serverIp = "10.0.1.100";
        final String serviceName = Calculator.class.getSimpleName();
        final String url = "rmi://" + serverIp + ":" + port + "/" + serviceName;

        System.out.println("Registering calculator object ...");
        CalculatorImpl engine = new CalculatorImpl();
        Naming.rebind(url, engine);
        System.out.println("Server listening on " + url);
    }
}