public class Item {

    boolean check = false;    
    //Other members 

    //Copy constructor
    public Item(Item itemToCopy) {
        check = itemToCopy.check;
        // set other members
    }
}