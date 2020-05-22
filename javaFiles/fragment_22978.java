package com.simplecalc.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import com.simplecalc.commons.Calculator;

public class CalculatorImpl extends UnicastRemoteObject implements Calculator {
    @Override
    public float add(float a, float b) throws RemoteException {
        float result = a + b;
        System.out.println("$ (" + a + " + " + b + ") = " + result);
        return result;
    }
}