// MyArrayList.java
import java.util.ArrayList;
class MyArrayList {
    public ArrayList<String> list;
}

// X10ArrayListProvider.java
public interface X10ArrayListProvider {
    public void getX10ArrayList(MyArrayList nameList);
}

// ArrayListProvider.x10
import MyArrayList;
import X10ArrayListProvider;
public class ArrayListProvider implements X10ArrayListProvider {
    public def getX10ArrayList(names:MyArrayList):void {
        // ...
    }
}