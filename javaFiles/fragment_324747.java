import java.util.ArrayList;


public interface SequentiallyOrdered {
        public OrderedThing getFirst();
        public OrderedThing getLast();
        public ArrayList<OrderedThing> getSequence();   
}