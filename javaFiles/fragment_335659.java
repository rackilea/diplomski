import java.util.*;

public class ans{
    public static void main(String[] args){
    LinkedList<Parent> list = new LinkedList<Parent>();

    list.add(new ChildA());
    list.add(new ChildB());
    list.add(new Parent());

    for(Parent p: list)
        System.out.println(p);
    }
}

class Parent{
    public String toString(){
    return "I am a Parent";
    }
}

class ChildA extends Parent{
    public String toString(){
    return "I am a ChildA";
    }
}

class ChildB extends Parent{
    public String toString(){
    return "I am a ChildB";
    }
}