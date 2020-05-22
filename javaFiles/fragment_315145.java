//Worker.java
import java.util.Scanner;

/**
 * a generic worker
 */
public class Worker {
    public final double bonus = 100;
    protected String name, workerID;
    protected double hourlyRate, totalHoursWorked, tax, grossSalary, netSalary;


    public void addWeekly(double hoursWorked) {
        this.totalHoursWorked = this.totalHoursWorked + hoursWorked;
    }

    public double gross() {
        grossSalary = (totalHoursWorked * hourlyRate);
        if (totalHoursWorked >= 150) {
            grossSalary = grossSalary + 100;
        }
        return grossSalary;
    }

    public double netAndTax() {
        netSalary = grossSalary;
        if (grossSalary > 500) {
            tax = (grossSalary - 500) * 0.3;
            netSalary = (grossSalary - tax);

        }
        return netSalary;
    }

    public String getName() {
        return this.name;
    }

    public String getWorkerID() {
        return this.workerID;
    }

    public double getHourlyRate() {
        return this.hourlyRate;
    }

    public double getTotalHours() {
        return totalHoursWorked;
    }

    public double getGrossSalary() {
        return grossSalary;
    }

    public void addToGross(double amt) {
        grossSalary = grossSalary + amt;
    }

    public void displaySalary() {
        System.out.print("Name: " + getName() + "\nID :" + getWorkerID()
                + "\nHourly Rate: " + getHourlyRate() + "\nTotalHours Worked"
                + getTotalHours() + "\nGross pay" + getGrossSalary() + "\nTax: "
                + netAndTax() + "\nNet Pay: " + netAndTax());
    }

    public void readFromInput(Scanner input) {
        name = input.nextLine();
        System.out.print("  ");
        this.workerID= input.nextLine();
        System.out.print("  ");
        this.totalHoursWorked = input.nextDouble();
        System.out.println();
    }

} // Worker

//MachineWorker.java
import java.util.Scanner;
public class MachineWorker extends Worker {

    private double targetAmount;
    private double totalPieces, productivityBonus;

    public void addWeekly(double hoursWorked, double weeklyAmount) {
        totalHoursWorked = hoursWorked + totalHoursWorked;
        totalPieces = weeklyAmount + totalPieces;
    }

    public double productivityBonus() {
        productivityBonus = 100 + (totalPieces - targetAmount);
        return productivityBonus;
    }

    public double gross() {
        grossSalary = (totalHoursWorked * hourlyRate) + productivityBonus;
        if (totalHoursWorked >= 150) {
            grossSalary = grossSalary + bonus;
        }
        return grossSalary;
    }

    public void addToGross(double amt) {
        amt = productivityBonus;
        grossSalary = grossSalary + amt;
    }

    @Override
    public void displaySalary() {
        super.displaySalary();
        System.out.println("Productivity Bonus  " + productivityBonus);
    }

    @Override
    public void readFromInput(Scanner input) {
        super.readFromInput(input);
        this.totalPieces = input.nextDouble();
    }
}

//Polymorphism PolyWorker.java

import java.util.*;

public class PolyWorkers {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        Worker[] workers = new Worker[5];

        char option = '0';
        String choice;

        for (int i = 0; i < 5; i++) {

            System.out.print("\tType of object " + (i + 1) + " [W/M]: ");
            choice = input.nextLine();

            if (choice.length() == 1) {
                option = choice.toLowerCase().charAt(0); // pick the first character
                switch (option) {
                case 'w': {
                    workers[i] = new Worker();
                    System.out.println("\n\tEnter name, ID and hours:   ");
                }
                    break;
                case 'm': {
                    System.out.print("\n\tEnter name, ID, hours and pieces: ");
                }
                    break;
                } // switch
                workers[i].readFromInput(input);
            }

            workers[i].displaySalary();
        }

    }
}