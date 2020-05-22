class Student {String name = "Joe Doe";}
class Node {
    Node next;
    Student student;
}
class Info {}
public class NodeSorter {

    Node start; 

    void sort()
    {
        Node ctr;
        Node innerctr;
        Info temp;
        Node max;
        ctr = start;

        while (ctr != null)
        {
            innerctr = ctr.next;
            max=ctr;

            while (innerctr != null)
            {
                if ((innerctr.student.name).compareTo (max.student.name) > 0)
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