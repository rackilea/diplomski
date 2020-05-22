public class Address{
        private String street;

public Address(){
            Keyboard k = new Keyboard();
            street = k.readString("Type in the Street: ");
}
public void change(){
        Keyboard k = new Keyboard();
        String str = "";
        System.out.println("If you do not wish to change the street, please just press enter.");
        str = k.readString("type in the Street: ");
            if (log.equals(""))
                str = str;
            else
                street = str;
}
}