import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        FOR obj=new FOR();
        List<String> str= obj.display();
        for(String v: str) {
            System.out.print(v);
        }

    }
}


import java.util.List;
import java.util.ArrayList;
List<String> display() {   
    int j=5;
    String hi="hi";

    List<String> result = new ArrayList<String>();

    for(int i=0;i<j;i++) {
        result.add(hi);         
    }
    return result;
}