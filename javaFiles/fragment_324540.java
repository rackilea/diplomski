package javabeat.samples;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class NameStore implements Serializable{
    private String firstName;
    private transient String middleName;
    private String lastName;
    public NameStore (String fName,
                         String mName,
                         String lName){
        this.firstName = fName;
        this.middleName = mName;
        this.lastName = lName;
    }
    public String toString(){
        StringBuffer sb = new StringBuffer(40);
        sb.append("First Name : ");
        sb.append(this.firstName);
        sb.append("Middle Name : ");
        sb.append(this.middleName);
        sb.append("Last Name : ");
        sb.append(this.lastName);
        return sb.toString();
    }
}
public class TransientExample{
    public static void main(String args[]) throws Exception {
        NameStore nameStore = new NameStore("Steve",
                                     "Middle","Jobs");
        ObjectOutputStream o = new ObjectOutputStream
                   (new FileOutputStream("nameStore"));
        // writing to object
        o.writeObject(nameStore);
        o.close();

        // reading from object
        ObjectInputStream in =new ObjectInputStream(
                new FileInputStream("nameStore"));
        NameStore nameStore1 = (NameStore)in.readObject();
        System.out.println(nameStore1);
    }
}