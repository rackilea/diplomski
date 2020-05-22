package com.example.demo;

public class LambdaDemo {

    public static void main(String[] args) {
        //doesn't compile
        //LambdaRestrictedInterface x = () -> {};
        LambdaRestrictedInterface y = new Test();
        y.print();
    }

    private static class Test implements LambdaRestrictedInterface {
        @Override
        public void print() {
            System.out.println("print");
        }
    }

    public interface MyInterface {
        void print();
    }

    public interface LambdaRestrictedInterface extends MyInterface {
        @Override
        default void print() {
            //hack prevents lambda instantiating
        }
    }
}