public class Driver {
public static void main(String args[]){

    Automotive auto = new Automotive();
    ReadSource read =  new ReadSource(auto);

    String main = "Message";
    //set the message and display
    read.set(main);

    //get the message that was set in the read.set(String)
    auto.getMessage();

    System.out.println(auto.getMessage());
}

public class ReadSource {

Automotive auto;

public ReadSource(Automotive auto) {
    this.auto = auto;
}

public void set(String message) {

    System.out.println("This messasge is in getMessage in the  class ReadSource: " + message);
    //Set the name for automotive
    auto.setName(message);
}