import java.util.Iterator;
import java.util.Vector;

public class TestClass {

    String Origin;
    String destination;
    String departure;
    String arrival;
    String amount;
    Vector<TestClass> v = new Vector<TestClass>();

    public TestClass(String Origin, String destination, String departure, String arrival, String amount) {
        this.Origin = Origin;
        this.destination = destination;
        this.departure = departure;
        this.arrival = arrival;
        this.amount = amount;
    }

    public static void main(String[] args){
        TestClass ticket = new TestClass("Caledonia", "South Korea", "10:00", "5:00", "15000");
        ticket.v.add(ticket);
        Iterator<TestClass> it = ticket.v.iterator();
        while(it.hasNext())
            System.out.println(it.next().Origin);
    }
}