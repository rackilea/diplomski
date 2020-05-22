import java.util.*;
import java.io.*;

public class Graphs
{
  int size;
  ArrayList<LinkedList<Integer>> ll;

  Graphs(int size)
  {
    this.size = size;

    ll = new ArrayList<LinkedList<Integer>>();

    for(int i=0; i<size; i++)
      ll.add(new LinkedList<Integer>());

  }

  public static void print(LinkedList<Integer> lli)
  {
    for(Integer i: lli)
      System.out.println(i);

    //for(int i=0; i<lli.size(); i++)
    //    System.out.println(lli.get(i));
  }

  public static void addEdge(Graphs graph, int up, int to)
  {
    graph.ll.get(to).add(up);
  }

  public static void main(String args[])
  {
    int V=5;
    Graphs graph = new Graphs(V);

    addEdge(graph,1,2);
    addEdge(graph,1,3);
    addEdge(graph,2,3);
    addEdge(graph,3,1);
    addEdge(graph,3,2);
    addEdge(graph,3,4);
    addEdge(graph,4,3);

    print(graph.ll.get(3));
  }
}