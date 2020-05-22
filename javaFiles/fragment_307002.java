import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

class MyClass
{
    public String name;
    public int[] myIntArray;

    public MyClass()
    {
        myIntArray = new int[10];
    }
}

public class Program
{
    static final int MAX_RANDOM = 20;

    public static void main(String[] args)
    {
        // Create a new map which will use keys of type String and
        // hold values of type MyClass.
        HashMap<String, MyClass> map = new HashMap<String, MyClass>();

        // Initialize a new random object. Not supplying a seed number
        // means that it seeds from the system clock, a good source of
        // randomness.
        Random rand = new Random();

        // Loop ten times...
        for (int i = 0; i < 10; ++i)
        {
            // ...and each time, create a new MyClass and call it "m"...
            MyClass m = new MyClass();

            // ...and set m.name as "c" followed by the iteration number.
            m.name = "c" + i;

            // Loop as many times as there are elements in m.myIntArray...
            for (int j = 0; j < m.myIntArray.length; ++j)
            {
                // ...and each time, set the next element to a new random int
                // with a value between 0 and MAX_RANDOM.
                m.myIntArray[j] = rand.nextInt(MAX_RANDOM);
            }

            // Once we've filled all the variables, push the object into
            // the map using its name as the lookup key.
            map.put(m.name, m);

            // The "m" variable now goes out of scope and the name can be
            // re-used on the next iteration of the loop. "map" and "rand"
            // stay in scope because they were declared outside the loop body.
        }

        // Now that we've created ten objects, time to read them back out.

        // Get an iterator object which will let us traverse the set of
        // keys (names) in the map.
        Iterator<String> i = map.keySet().iterator();
        // While i still has more keys in the set...
        while (i.hasNext())
        {
            // Grab the next name from the iterator and assign it to
            // a local variable called "name".
            String name = i.next();

            // Fetch the instance of MyClass from the map that corresponds
            // to the key (name) we've just grabbed.
            MyClass m = map.get(name);

            // Print its name to the console...
            System.out.println("Name: " + m.name);

            // Print an opening bracket for the array...
            System.out.print("[");
            // ...and now run through each of the integers in the array
            // and print those out, too.
            for (int j = 0; j < m.myIntArray.length; ++j)
            {
                // Print the integer at position j...
                System.out.print(m.myIntArray[j]);
                // ...and if it's not the last item in the array,
                // print a comma to separate it from the next one.
                if (j < m.myIntArray.length - 1) System.out.print(", ");
            }
            // Print the closing bracket, followed by two newlines to
            // separate the next class with whitespace.
            System.out.println("]\n");
        }
    }
}