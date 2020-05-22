package edu.blah.class.project1;

public class Program {

    public int run(String args[]) {
        return Utility.analyze();
    }

    public static void main(String[] args) {
        try {
            new Program().run(args);
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
}