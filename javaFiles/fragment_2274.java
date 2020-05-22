package de.scrum_master.app;

public class Application {
    private final static String[] NAMES = { "Name1", "Name2", "Name3" };

    public static void main(String[] args) {
        for (String name : NAMES)
            System.out.println(name);
    }
}