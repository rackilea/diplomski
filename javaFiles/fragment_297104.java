package test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Queue;



public class Test {

  public static void main(String[] argv) {
    List<Integer> intList = Arrays.asList(1,2,3,4,5);
    Collections.shuffle(intList);
    Queue<Integer> intQueue = new ArrayDeque<Integer>(intList);
    Integer x;
    while ((x = intQueue.poll()) != null) {
      System.out.println(x);
    }
  }

}