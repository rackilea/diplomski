class Student implements Comparable <Student> {
    String name = "Joe Doe";
    public int compareTo (Student other) {
        if (other == null) return 1;
        return name.compareTo (other.name);
    }   
}
class Node <T> {
    Node <T> next;
    T value;
}
class Info {}
public class NodeSorter {

    Node <Comparable> start;    

    void sort ()
    {
        Node <Comparable> ctr;
        Node <Comparable> innerctr;
        Info temp;
        Node <Comparable> max;
        ctr = start;

        while (ctr != null)
        {
            innerctr = ctr.next;
            max=ctr;

            while (innerctr != null)
            {
                if ((innerctr.value).compareTo (max.value) > 0)
                {
                    max = innerctr;
                }
                innerctr=innerctr.next;
            }
            //swapping...
            ctr = ctr.next;
        }
    }
}