public class Main {
    public static void main(String[] args) {
        PQ list = new PQ();

        //Insert test code here:
        list.addtopq("First",20);
        list.addtopq("Second",3);
        list.addtopq("Third", 1);
        list.addtopq("Forth",3);
        list.addtopq("Fifth",2);
        list.addtopq("Sixth",4);
        list.tostring();

import java.util.LinkedList;

class InvalidPrioty extends RuntimeException{
    public InvalidPrioty(String s){
        super(s);
    }
}

class PQ extends LinkedList{

    public void addtopq(String s, Integer p){
        if (p<1 || p>20) throw new InvalidPrioty("Priority number must be between 1 and 20");
        System.out.println("Adding "+'"'+s+'"'+" with priority "+p);
        int pos = 0;
        int k;
        int i = 1;
        PQ nlist = new PQ();
        //The list will initially be empty so the first call the the addtopqmethod
        // will add the objects to the queue and avoid errors when checking if objects values
        // are greater than null.
        if (isempty()){
            addLast(s);
            addLast(p);
        }else {
           while (i<size()){
               // Creates an object to see whether the priority in the item being added is higher
               // than the one in the queue already.
                Integer x  = Integer.valueOf(get(i).toString());
               //The loop will break if priority is less than or equal to x so that it can place it behind the items
               //with higher or the same priority. I assumed that as long as all the strings in the list with the same
               //priority were together, that it wouldn't matter what order they in.
                if (p > x) pos = 1;
                else  if (p<=x){
                    pos = 0;
                    break;
                }
               i=i+2;
            }
            //Adds to the end of the que as it has the largest priority
            if (pos==1){
                addLast(s);
                addLast(p);
            }
            if (pos==0){

                //Adds everything up to the one being replaced into a seperate list...
                for (k=0; k<(i-1); k++) nlist.add(k, get(k));
                //Adds the new String with its priority into the List...
                nlist.addLast(s);
                nlist.addLast(p);
                //Adds the rest of the items
                for (; k<size(); k++) nlist.add(get(k));
                //Clears the list and adds the new order
                clear();
                addAll(nlist);
                nlist.clear();
            }
        }
    }

    public boolean isempty(){
        if (contains(null)) return true;
        else return false;
    }


Output:

Adding "First" with priority 20
Adding "Second" with priority 3
Adding "Third" with priority 1
Adding "Forth" with priority 3
Adding "Fifth" with priority 2
Adding "Sixth" with priority 4

Queue Contents: <"Third":1,"Fifth":2,"Forth":3,"Second":3,"Sixth":4,"First":20>