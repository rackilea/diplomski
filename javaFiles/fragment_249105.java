import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;

public class CloneTest implements Cloneable, Serializable {
private static final long serialVersionUID = 5971741470680723802L;

public static void main(String[] args) {

    try {
        CloneTest original = new CloneTest();

        System.out.println();
        System.out.println("### shallow clone");

        CloneTest cloned=original.clone();
        compare(original, cloned);
        original.setHireDay(1993,2,22);
        cloned.setHireDay(2000,11,22);
        compare(original, cloned);

        System.out.println();
        System.out.println("### shallow clone - mutable hiredate");

        cloned.hireDayMutable = true;
        cloned.setHireDay(2002,11,22);
        compare(original, cloned);

        System.out.println();
        System.out.println("### deep clone");

        cloned = clone(original);
        compare(original, cloned);
        cloned.setHireDay(2004,11,22);
        compare(original, cloned);

    } catch(Exception e){
        e.printStackTrace();
    }
}

private Date hireDay;
public boolean hireDayMutable;

public CloneTest() {
    super();
    hireDay=new Date();
    System.out.println("New instance");
}

public void setHireDay(int year, int month, int day) {

    if (hireDayMutable) {
        hireDay = new GregorianCalendar(year,month-1,day).getTime();
    } else {
        Date newhireDay = new GregorianCalendar(year,month-1,day).getTime();
        hireDay.setTime(newhireDay.getTime());
    }
}

public CloneTest clone() throws CloneNotSupportedException {

    CloneTest cloned = (CloneTest)super.clone();
    return cloned;
}

public String toString() {
    return "CloneTest[hireday=" + hireDay + "]";
}

public static void compare(CloneTest original, CloneTest cloned) {

    System.out.println();
    System.out.println("The same object  : " + (cloned == original));
    System.out.println("The same hireDate: " + (cloned.hireDay == original.hireDay));
    System.out.println("original = " + original);
    System.out.println("cloned   = " + cloned);
}

/**
 * Clones an object by serializing and then unserializing it ("deep copy").
 */
@SuppressWarnings("hiding")
public static <T> T clone(T o) {
    return clone(o, 512);
}

@SuppressWarnings({ "unchecked", "hiding" })
public static <T> T clone(T o, int bufSize) {
    return (T) unserialize(serialize(o, bufSize));
}

public static byte[] serialize(Object o, int bufSize) {

    ByteArrayOutputStream baos = new ByteArrayOutputStream(bufSize);
    try {
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject((Serializable)o);
        oos.close();
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
    byte[] ba = baos.toByteArray();
    // log.trace("Serialized size: {}", ba.length);
    return ba;
}

public static Object unserialize(byte[] ba) {

    Object o = null;
    try {
        ByteArrayInputStream bais = new ByteArrayInputStream(ba);
        ObjectInputStream oin = new ObjectInputStream(bais);
        o = oin.readObject();
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
    return o;
}

}