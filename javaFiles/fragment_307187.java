import java.util.Scanner;

public class XOBYT
{

    public static void main(String[] args)
    {
        String choice;
        Scanner scan = new Scanner(System.in);
        System.out.println("COPYRIGHT 2016 HARBNGER STUDIOS\nYou wake up in a broken-down alabaster\nhouse with no knowledge of who\nyou are or where you came from.\nWhich direction do you want to head? (options: NORTH, SOUTH, EAST, WEST)");
        choice = scan.nextLine();
        if(choice.equals("NORTH")){System.out.println("\n\n\n\n--TERMINAL_LOG--\n\nI FOUND THIS HANDHELD TERMINAL LOG FIGURED I'D\nPUT IT TO SOME USE. TODAY IS, ACCORDING TO THIS, THE 15TH OF JAN, 2644.\n\nI TRAVELED NORTH TO A RUN-DOWN VILLAGE. CARCASSES EVERYWHERE.\nNO SURVIVORS. I WONDER WHAT HAPPENED HERE.\nI LOOTED THE BODIES, TALOS BLESS MY SOUL. I FOUND A PISTOL AND SOME GAUZE. I CAN VIEW MY INVENTORY, HIT THE ROAD, OR LINGER AROUND.\n\n(options: INVENTORY,ROAD,LINGER)");}
            choice = scan.nextLine();
        if(choice.equals("INVENTORY")){
        System.out.println("\n\n\n\n--TERMINAL_LOG--\n\nI FOUND THIS HANDHELD TERMINAL LOG FIGURED I'D\nPUT IT TO SOME USE. TODAY IS, ACCORDING TO THIS, THE 15TH OF JAN, 2644\n\nI TRAVELED SOUTH AND STOPPED AT AN ABANDONED\nOUTPOST. IT HAS SOME SUPPLIES. I PICKED\nUP A PISTOL AND SOME NANITE SYRINGES. I CAN CHECK\nMY INVENTORY, MOVE FARTHER SOUTH, OR EXPLORE.\n\n(options: INVENTORY,FARTHER,EXPLORE)");}
        choice = scan.nextLine();
        if(choice.equals("FARTHER")){
        System.out.println("\n\n\n\n--TERMINAL_LOG--\n\nI FOUND THIS HANDHELD TERMINAL LOG FIGURED I'D\nPUT IT TO SOME USE. TODAY IS, ACCORDING TO THIS, THE 15TH OF JAN, 2644.\n\nI TRAVELED EAST AND STOPPED BY A DIRTY STREAM.\nIT'S FILLED WITH GARBAGE, BUT THERE ARE ALSO PLASTIC BOTTLES.\nSHOULD I FILL THEM WITH WATER OR MOVE ON?\n\n(options: FILL,MOVE)");}
        choice = scan.nextLine();
        if(choice.equals("EXPLORE")){
        System.out.println("\n\n\n\n--TERMINAL_LOG--\n\nI FOUND THIS HANDHELD TERMINAL LOG FIGURED I'D\nPUT IT TO SOME USE. TODAY IS, ACCORDING TO THIS, THE 15TH OF JAN, 2644.\n\nI TRAVELED WEST AND FOUND AN ABANDONED SHACK.\nSHOULD I SEARCH IT FOR LOOT OR MOVE ON?\n\n(options: SEARCH,MOVE)");}}
        choice = scan.nextLine();

        if(choice.equals("SOUTH")){
            System.out.println("\n\n\n\n--TERMINAL_LOG--\n\nI FOUND THIS HANDHELD TERMINAL LOG FIGURED I'D\nPUT IT TO SOME USE. TODAY IS, ACCORDING TO THIS, THE 15TH OF JAN, 2644\n\nI TRAVELED SOUTH AND STOPPED AT AN ABANDONED\nOUTPOST. IT HAS SOME SUPPLIES. I PICKED\nUP A PISTOL AND SOME NANITE SYRINGES. I CAN CHECK\nMY INVENTORY, MOVE FARTHER SOUTH, OR EXPLORE.\n\n(options: INVENTORY,FARTHER,EXPLORE)");}
        choice = scan.nextLine();
        if(choice.equals("EAST")){
            System.out.println("\n\n\n\n--TERMINAL_LOG--\n\nI FOUND THIS HANDHELD TERMINAL LOG FIGURED I'D\nPUT IT TO SOME USE. TODAY IS, ACCORDING TO THIS, THE 15TH OF JAN, 2644.\n\nI TRAVELED EAST AND STOPPED BY A DIRTY STREAM.\nIT'S FILLED WITH GARBAGE, BUT THERE ARE ALSO PLASTIC BOTTLES.\nSHOULD I FILL THEM WITH WATER OR MOVE ON?\n\n(options: FILL,MOVE)");}
        choice = scan.nextLine();
        if(choice.equals("WEST")){
            System.out.println("\n\n\n\n--TERMINAL_LOG--\n\nI FOUND THIS HANDHELD TERMINAL LOG FIGURED I'D\nPUT IT TO SOME USE. TODAY IS, ACCORDING TO THIS, THE 15TH OF JAN, 2644.\n\nI TRAVELED WEST AND FOUND AN ABANDONED SHACK.\nSHOULD I SEARCH IT FOR LOOT OR MOVE ON?\n\n(options: SEARCH,MOVE)");}}
       choice = scan.nextLine();
    }