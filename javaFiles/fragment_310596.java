package com.mycompany.myproject;
public class Dummy1{

    public static void main(final String[] args){
        final Dummy1 dummy = new Dummy1();
        dummy.doSomeStuff();
        dummy.doSomeStuffWithSomeArgs("Hello", 123);
    }

    private void doSomeStuff(){}

    public void doSomeStuffWithSomeArgs(final String firstArg,
        final int secondArg){}

}