import java.util.EmptyStackException;
import java.util.Vector; 

 public class Stack extends Vector{

  /**
 * Creates an empty Stack.
 */
public Stack() {

}


public E pop() {
    E   obj;
    int len = size();

    if (len == 0)
        throw new EmptyStackException();
    obj = elementAt(len - 1);
    removeElementAt(len - 1);
    return obj;
}


public void push(E e) {

    if(e==null)
        throw new NullPointerException();
    addElement(e);

}


public int size() {
    return elementCount;
}


public static void main(String args[]){


Stack<Integer>  integerStack= new Stack<Integer>();

//(7,1,3,3,5,1,2,4,3)
integerStack.push(7);
integerStack.push(1);
integerStack.push(3);
integerStack.push(3);
integerStack.push(5);
integerStack.push(1);
integerStack.push(2);
integerStack.push(4);
integerStack.push(3);


System.out.println("STACK WITH INTEGER ELEMENTS");
//Size
System.out.println("Size of the Stack is : "+integerStack.size());



// String Stack
Stack<String>  stringStack= new Stack<String>();

//("abc","def","acd","fgi","fth","lmn","zxy","cde","adr")
stringStack.push("abc");
stringStack.push("def");
stringStack.push("acd");
stringStack.push("fgi");
stringStack.push("fth");
stringStack.push("lmn");
stringStack.push("zxy");
stringStack.push("cde");
stringStack.push("adr");


System.out.println("STACK WITH STRING ELEMENTS");
//Size
System.out.println("Size of the Stack is : "+stringStack.size());



//pop
stringStack.pop();

//Size after pop
System.out.println("Size of the Stack After pop is : "+stringStack.size());


 }

 }