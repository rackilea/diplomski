import java.io.File;
 import java.util.Scanner;

 public class LinkedList
    {
        Node head;

        public static void main(String[] args)
        {
            LinkedList list = new LinkedList();
            list.initializeLL();
            list.printLinkedList();
        }

        private void printLinkedList(){
            System.out.println(head);
        }

        private void initializeLL()
        {
            Node currentNode = head;
            try
            {
                File file = new File("Asg2Data.txt");
                Scanner sc = new Scanner(file);
                while (sc.hasNext())
                {
                    Data d = new Data(sc.next(), sc.nextInt());
                    Node n = new Node(d);
                    if(currentNode == null){
                        currentNode = n;
                        head = n;
                    }else{
                        currentNode.setNextNode(n);
                        currentNode = n;
                    }
                }
                sc.close();
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }

    }

    class Node
    {

        private Data data;

        private Node nextNode;

        public Node(Data data)
        {
            this.data = data;
        }

        public Data getData()
        {
            return data;
        }

        public void setData(Data data)
        {
            this.data = data;
        }

        public Node getNextNode()
        {
            return nextNode;
        }

        public void setNextNode(Node nextNode)
        {
            this.nextNode = nextNode;
        }

        @Override
        public String toString()
        {
            return "Node [data=" + data + ", nextNode=" + nextNode + "]";
        }



    }

    class Data
    {

        private String name;

        private int data;

        public Data(String name, int data)
        {
            this.name = name;
            this.data = data;
        }

        public String getName()
        {
            return name;
        }

        public void setName(String name)
        {
            this.name = name;
        }

        public int getData()
        {
            return data;
        }

        public void setData(int data)
        {
            this.data = data;
        }

        @Override
        public String toString()
        {
            return "Data [name=" + name + ", data=" + data + "]";
        }
    }