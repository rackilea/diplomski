package de.scrum_master.app;

public class Application {
    public static void main(String[] args) {
        Application application = new Application();
        System.out.println("Directly recursive factorials:");
        for (int i = 0; i < 12; i++)
            System.out.printf("%2d! = %10d%n", i, application.factorial(i));
        System.out.println("\nIndirectly recursive factorials:");
        for (int i = 0; i < 12; i++)
            System.out.printf("%2d! = %10d%n", i, application.factorial_indirect(i));
    }

    public int factorial(int i) {
        return i > 1 ? i * factorial(i - 1) : 1;
    }

    public int factorial_indirect(int i) {
        return helper(i);
    }

    public int helper(int i) {
        return i > 1 ? i * factorial_indirect(i - 1) : 1;
    }
}