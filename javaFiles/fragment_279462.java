package com.stackoverflow.graph;

 import java.util.ArrayList;
 import java.util.HashMap;
 import java.util.Iterator;
 import java.util.List;
 import java.util.Map;

 /**
  * This class manages the Directed Graph creation, and all the methods related to build a Directed Graph  
  *
  */
 public class DirectedGraph {
     Map<Node, List<Node>> graph;

     public DirectedGraph() {
         this.graph = new HashMap<Node, List<Node>>();
     }

     void createRelationship(Node input, Node output) {
         List<Node> outputs = graph.get(input);
         //If is a new node create their output list, (all the nodes to which it has relationship)
         if (outputs == null)
             outputs = new ArrayList<Node>();
         //Check that the node is not in the list, to avoid duplication
         if (!outputs.contains(output)){
             outputs.add(output);
             graph.put(input,outputs);
         }
     }

     void printGraph(){
         Iterator it = this.graph.entrySet().iterator();
         while (it.hasNext()) {
             Map.Entry pair = (Map.Entry)it.next();
             List<Node> outputs = (List<Node>) pair.getValue();
             for(Node node : outputs){
                 System.out.print(pair.getKey().toString() + "-->" + node + " ");
             }
             it.remove(); // avoids a ConcurrentModificationException
         } 
     }


 }

 ------------------

 package com.stackoverflow.graph;

 public class Node {
     //This is the only field you need for your implementation
     private Integer value;

     public Node(int value){
         this.value = value;
     }


     public Integer getValue() {
         return value;
     }

     public void setValue(Integer value) {
         this.value = value;
     }

     @Override
     public String toString() {
         return value.toString();
     }
 }

 ----------------------

 package com.stackoverflow.graph;

 public class App {

     public static void main(String[] args) {
         DirectedGraph graph = new DirectedGraph();

         //This is the final result, with your parse you must prepare this code to run in this way:
         Node n1 = new Node(1);//Instead of the hardcoded values 1,2,3,4,5 take the parsed ones
         Node n2 = new Node(2);
         Node n3 = new Node(3);
         Node n4 = new Node(4);
         Node n5 = new Node(5);


         //put this code into a loop to create each edge
         graph.createRelationship(n1, n2);
         graph.createRelationship(n3, n4);
         graph.createRelationship(n3, n5);
         //Duplicate relationship but not added
         graph.createRelationship(n3, n5);

         graph.printGraph();
     }
 }