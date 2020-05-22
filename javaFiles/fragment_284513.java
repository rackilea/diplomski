import java.util.Iterator;
import java.util.LinkedList;

public class MyLinkedList extends LinkedList {

Iterator<String> it = null;
String largest="";

public String findLargest(){
    if (it == null) {
        it = super.iterator();
    }   

    if (it.hasNext()==false){
        it = null;
        return largest;
    }
    else{
        String temp = it.next();
        int x=largest.compareTo(temp);
        if(x<0){
            largest=temp;
        }
        findLargest();
    }
    return largest;
}}