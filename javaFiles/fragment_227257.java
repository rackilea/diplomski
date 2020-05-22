import java.util.*;
public class Test {
    public static void main (String[] args) {
        Queue myQueue = new Queue(10);
        ArrayList<String> myList = new ArrayList<String>();
        while(!myQueue.isEmpty()) {
            myList.add((String)myQueue.dequeue());
        }       
        TreeMap<Character, Integer> counts = new TreeMap<Character, Integer>();
        for(int i = 0; i < myList.size(); i++) {
            String country = myList.get(i);
            Character first = Character.toUpperCase(country.charAt(0));
            if(counts.get(first) == null) {
                counts.put(first, 0);
            }
            counts.put(first, counts.get(first) + 1);
        }
        //Now print the counts
        TreeSet<Character> keySet = new TreeSet<Character>(counts.keySet());
        Iterator<Character> iterator = keySet.iterator();
        while(iterator.hasNext()) {
            Character key = iterator.next();
            System.out.println("Total number of countries start with " + key + " : " + counts.get(key));
        }
    }
}

class Queue {
        String[] items;
        int pointer = 10;
    Queue(int size) {
        items = new String[10];
        items[0]="Austria";
        items[1]= "United States";
        items[2]="Nepal";
        items[3]="Bhutan";
        items[4]="China";
        items[5]="Brazil";
        items[6]="Africa";
        items[7]="Sri Lanka";
        items[8]="Italy"; 
        items[9]="India";
    }
    Object dequeue() {
        pointer--;
        return items[pointer];
    }
    boolean isEmpty() {
        return pointer == 0;
    }   
}