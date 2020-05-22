package com.vehicles.project;

import java.util.Scanner;

public class Main_Vehicles_Fase1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter your plate, car brand and color");

        Car userCar = new Car(sc.nextLine(), sc.nextLine(), sc.nextLine());

        System.out.println("Your plate is: " + userCar.plate + ", the brand is " + userCar.brand + " and the colour is "
                + userCar.color);

        System.out.println("Enter backwheels brand and diameter");

        Wheel userBackWheels = new Wheel(sc.nextLine(), new Double(sc.nextLine()));

        System.out.println("Your backwheels info --> " + userBackWheels.infoWheel());

        System.out.println("Enter frontwheels brand and diameter");

        Wheel userFrontWheels = new Wheel(sc.nextLine(), new Double(sc.nextLine()));

        System.out.println("Your frontwheels info --> " + userFrontWheels.infoWheel());

        sc.close();

    }
}