import java.util.*;
import com.ibm.as400.access.*;

public class TestObjectList {
    public static void main(String[] args) {

try {
    AS400 system = new AS400();

    ObjectList msgqs = new ObjectList(system, ObjectList.ALL, ObjectList.ALL, "*MSGQ");

    Enumeration e = msgqs.getObjects();

    while (e.hasMoreElements()) {
        ObjectDescription msgq = (ObjectDescription) e.nextElement();
        System.out.println(msgq.getLibrary() + "/" + msgq.getName());
        }

    System.out.println("End of message queues.");

    } catch (Exception e) {
      e.printStackTrace();
    }

System.exit(0);
}

}