package mainFuncs;

import java.util.Scanner;

public class mainMenu {

    public static void main(String args[]){

        Scanner scan = new Scanner(System.in);
        aBug[] myBugs = new aBug[5];

        bugScan(myBugs, scan);
        System.out.print("hi");
    }

    public static void bugScan(aBug[] bugObjects, Scanner scan) {

        String inSpecies, inName;
        int inX, inY, inEnergy, inId;

        for(int i = 0; i < bugObjects.length; i++)
        {
            System.out.print("Species: ");
            inSpecies = scan.nextLine();

            System.out.print("Name: ");
            inName = scan.nextLine();

            System.out.print("X position: ");
            inX = scan.nextInt();

            System.out.print("Y position: ");
            inY = scan.nextInt();

            System.out.print("Energy: ");
            inEnergy = scan.nextInt();

            System.out.print("ID: ");
            inId = scan.nextInt();

            bugObjects[i].symbol = '*';
            bugObjects[i].species = inSpecies;
            bugObjects[i].name = inName;
            bugObjects[i].x = inX;
            bugObjects[i].y = inY;
            bugObjects[i].energy = inEnergy;
            bugObjects[i].id = inId;
        }
    }
}