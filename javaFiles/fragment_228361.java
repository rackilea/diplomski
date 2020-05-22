import java.util.Queue;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.HashSet;
import java.util.Comparator;

public class PriorityQueueTest {

    public static class Pair {
        private String text;
        private int frequency;

        @Override
        public int hashCode() {
            return text.hashCode();
        }

        @Override
        public String toString() {
            return text + ":" + frequency;
        }

        public Pair(String text, int frequency) {
            super();
            this.text = text;
            this.frequency = frequency;
        }

        public String getText() {
            return text;
        }
        public void setText(String text) {
            this.text = text;
        }
        public int getFrequency() {
            return frequency;
        }
        public void setFrequency(int frequency) {
            this.frequency = frequency;
        }
    }

    public static Comparator<Pair> idComparator = new Comparator<Pair>(){
        @Override
        public int compare(Pair o1, Pair o2) {
            if(o1.getFrequency() > o2.getFrequency()) {
                return -1;
            }
            else if(o1.getFrequency() < o2.getFrequency()){
                return 1;
            }
            else {
                return 0;
            }
        }
    };

    public static void main(String[] args) {
        Set<Pair> data = new HashSet<Pair>();
        data.add(new Pair("haha", 3));
        data.add(new Pair("Hehe", 5));
        data.add(new Pair("Test", 10));

        Queue<Pair> queue = new PriorityQueue(16, idComparator);

        for(Pair pair : data) {
            queue.add(pair);
        }

        // Test the order
        Pair temp = null;
        while((temp = queue.poll()) != null) {
            System.out.println(temp);
        }

    }

}