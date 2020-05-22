package com.simplecalc.client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import com.simplecalc.commons.Calculator;

public class CalculatorClient {

public static void main(String[] args) throws RemoteException, NotBoundException {
        final int port = 1099;
        final String serverIp = "10.0.1.100";
        final String serviceName = Calculator.class.getSimpleName();
        final String url = "rmi://" + serverIp + ":" + port + "/" + serviceName;

        Calculator calculator = (Calculator) Naming.lookup(url);
        float result = calculator.add(10F, 5F);
        System.out.println("Result: " + result);
    }
}