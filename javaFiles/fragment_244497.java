import java.util.*;
import java.io.*;
public class Javavison {

static String name[]=new String[10000];
static int time[]=new int[10000];
static int day []=new int[10000];
static int positionCounter=0;

public static void main(String args[]) throws IOException {
    int menuChoice=1;
    System.out.println("Hello and Welcome to Javavision");
    while(menuChoice!=6){
        System.out.println("Enter Menu Choice");
        System.out.println("(1) Enter TV Shows/Add a TV Show");
        System.out.println("(2) Modify TV Show");
        System.out.println("(3) Delete TV Show");
        System.out.println("(4) Sort TV Shows");
        System.out.println("(5) Show all TV Shows");
        System.out.println("(6) Exit Program");

        Scanner scn = new Scanner(System.in);
        menuChoice=scn.nextInt();

        if(menuChoice==1){
            addShow();
        }
        else if(menuChoice==2){
            modShow();
        }
        else if(menuChoice==3){
            deleteShow();
        }
        else if(menuChoice==4){
            sortShow();
        }
        else if(menuChoice==5){
            showShows();
        }
        else if(menuChoice==6){
            break;
        }
    }
}

public static void addShow(){
    positionCounter++;
    BufferedReader in;
    in=new BufferedReader(new InputStreamReader(System.in));
    System.out.println("Enter Name of Show");
    try{
        name[positionCounter]=in.readLine();
    }
    catch(IOException ie) {
     ie.printStackTrace();
    }
    System.out.println("Enter Day of Show");
    try{
        day[positionCounter]=in.read();
    }
    catch(IOException ie) {
     ie.printStackTrace();
    }
    System.out.println("Enter Time of Show(In military time, For example 2:30am=0230");
    try{
        time[positionCounter]=in.read();
    }
    catch(IOException ie) {
     ie.printStackTrace();
    }

}

public static void modShow() throws IOException{
    String name[]=new String[2];
    int forLoopCounter=0;
    BufferedReader in;
    in=new BufferedReader(new InputStreamReader(System.in));
    System.out.println("Enter Name of Show that you would like to modify");
    try{
        name[1]=in.readLine();
    }
    catch(IOException ie) {
     ie.printStackTrace();
    }

    for(int a=1; a<=positionCounter;a++){
        forLoopCounter=a;
        if(name[1].compareTo(name[a]) ==0){
            a=positionCounter+2;
        }
    }
    if(forLoopCounter!=(positionCounter+1)){
        //allow user to modify information because name has been found
        System.out.println("Enter New Name: ");
        name[positionCounter] = in.readLine();
        System.out.println("Enter New Time: ");
        time[positionCounter] = Integer.valueOf(in.readLine()).intValue();
        System.out.println("Enter New Day: ");
        day[positionCounter] = Integer.valueOf(in.readLine()).intValue();
    }
    else{
        //tell the user the name he entered is not in the data list
        System.out.println("Sorry The show you requested is not available");
    }
}

public static void deleteShow(){
    BufferedReader in;
    in=new BufferedReader(new InputStreamReader(System.in));

}

public static void sortShow(){
    BufferedReader in;
    in=new BufferedReader(new InputStreamReader(System.in));

}

public static void showShows(){
    BufferedReader in;
    in=new BufferedReader(new InputStreamReader(System.in));
}
}