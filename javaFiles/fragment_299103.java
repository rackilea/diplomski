package test;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import javax.swing.text.Position;

public class Cars {

private String carID;
private String plateNum;
private String position;
private Attendant assignedTo;
private long currTime;
static ArrayList<String> tempArray2 = new ArrayList<String>();

static{
    createCarsID();
}

public Cars() {
    this.carID = Cars.getID();
    this.plateNum = Cars.askCarID();
    this.position = Cars.generatePosition();
    this.assignedTo = Attendant.askForAtt();
    this.currTime = System.currentTimeMillis();
}

public static void createCarsID() {

    for (int x = 0; x < Garage.getCarsCapacity(); x++) {
        String tempCarID = ("CR" + (x + 1));
        tempArray2.add(tempCarID);
    }
}

public static String getID() {


    String tempID = null;
    String tempPos = null;
    for (int x = 0; x < Garage.getCarsCapacity(); x++) {
        if (tempArray2.get(x) != null) {
            tempID = tempArray2.get(x);
            tempPos = tempArray2.get(x);
            //tempArray2.remove(tempArray2.get(x));
            //getPos(tempPos);
            //tempArray2.get(x) = null;
            break;
        }
    }
    return tempID;
}
public static String generatePosition() {


    String tempID = null;
    String tempPos = null;
    for (int x = 0; x < Garage.getCarsCapacity(); x++) {
        if (tempArray2.get(x) != null) {
            tempID = tempArray2.get(x);
            tempPos = tempArray2.get(x);
            tempArray2.remove(tempArray2.get(x));
            return getPos(tempPos);
            //tempArray2.get(x) = null;

        }
    }
    return null;
}

public static String getPos(String IdToPos) {
    String strPos = IdToPos.substring(2);
    int pos = Integer.parseInt(strPos);
    return  "GR" + pos;

}

public String getPlateNum() {
    return plateNum;
}


public String getCarID() {
    return carID;
}

public String getPosition() {
    return position;
}

public long getCurrTime() {
    return currTime;
}

public Attendant getAssignedTo() {
    return assignedTo;
}

public static String askCarID() {
    boolean valid = false;
    System.out.println("Please enter your car's plate number.");
    Scanner scanCarID = new Scanner(System.in);
    String scannedCarID = scanCarID.nextLine();
    while (!valid) {
        if (scannedCarID.matches("^[A-Za-z][A-Za-z] [0-9][0-9][0-9]$")) {
            valid = true;
            System.out.println(scannedCarID);
        } else {
            System.out.println("Please enter a valid plate number. Ex: AF 378");
            askCarID();
        }
    }
    return scannedCarID.toUpperCase();
}

public String convert(long miliSeconds) {
    int hrs = (int) TimeUnit.MILLISECONDS.toHours(miliSeconds) % 24;
    int min = (int) TimeUnit.MILLISECONDS.toMinutes(miliSeconds) % 60;
    int sec = (int) TimeUnit.MILLISECONDS.toSeconds(miliSeconds) % 60;
    return String.format("%02d:%02d:%02d", hrs, min, sec);
}

    @Override
    public String toString() {
        return "Car:" + plateNum + " ID:" + carID + " Position:" + position + " Assigned to:" + assignedTo.getId() 
        + "(" + assignedTo.getName() + ")" + " Parked at:" + convert(currTime);
    }
}