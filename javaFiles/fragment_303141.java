import java.util.List;
import java.util.ArrayList;

public class A implements B{

private List<String> s;

public A() {
    s = new ArrayList<String>();
    s.add("Bob");
    s.add("Alice");
    s.add("Eve");
}
//overridden method from interface B
public int t(){
  //what you want this method to do
}
//overridden method from interface B
public boolean f(int a, int b){
  //what you want this method to do
}
public String s(){ 
    A test = new A();
    int t = test.t(); 
    String r = "Hello ";
    for (String z : s) {
        boolean x = test.f(t, 5);
        if (x) {
            r = r + z;
        }
    }
    return r;
}

// main added by myself for testing purpose
public static void main(String[] args){
    A test = new A();
    System.out.println(test.s()); //printing the result of `test.s()`
}
}
interface B{
  int t();//complex calculus
  boolean f(int a, int b); // complex algorithm
}