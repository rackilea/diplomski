package main;

import java.awt.Dimension;

public class Foo {

    public static void main(String[] args) {
        Dimension screenSize = java.awt.Toolkit.getDefaultToolkit()
                .getScreenSize();
        System.out.println(screenSize);
    }
}