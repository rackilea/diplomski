package linkedList;

import java.util.*;
//import org.w3c.dom.Node;  No need for this

public class ListOne {
    // .....
    public static MyNode head;
    private class MyNode{
        private int data;
        private MyNode next;

        public MyNode(int data){
            this.data = data;
            this.next = null;
        }
    }
    //BUILD LIST
    public void buildList(int value){
        MyNode newNode = new MyNode(value);
        newNode.next = head;
        head = newNode;
    }
    // etc....
}