public class Storage{
    private String outString;

    public Storage(){
        AClass myThread = new AClass(this);
        myThread.start();
    }
    public void setInString(String sendString){
        this.outString = sendString; //push seems not to be supported by MIDP
    }
}

public class AClass {
    Storage myStorage;

    public AClass(Storage s) {
        this.myStorage = s;
    }

    public void run(){
        myFunction("write this into Storage var outString");
    }

    private myFunction(String myString) {
        myStorage.setInString(myString);
    }
}