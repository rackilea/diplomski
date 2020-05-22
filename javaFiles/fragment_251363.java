import java.io.*;
import java.util.*;

public class StudentList<T> extends LinkedList<T>
{
private int newInt;
private boolean newE;

public StudentList(){
   super();
}
public StudentList(int i, boolean e) {
    newInt = i;
    newE = e;
}

public boolean offer(boolean e) {
   return e;
}


}