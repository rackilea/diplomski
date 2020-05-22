public class ListMain {

public static void main(String[] args){
  IntSLList myList = new IntSLList();

  myList.addToHead(1);
  myList.addToTail(2);
  System.out.println("myList.isEmpty() = " + myList.isEmpty());
}

}