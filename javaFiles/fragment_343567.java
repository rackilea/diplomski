public class MainClassForQueue {

        public static void main(String[] args) throws Exception {

            Node n1=new Node("A","1000000","2017-02-16","ABC");
            Node n2=new Node("B","1100000","2017-02-16","ABC");
            Node n3=new Node("C","0100000","2017-02-16","ABC");
            Node n4=new Node("D","0010000","2017-02-16","ABC");
            Node n5=new Node("F","1010000","2017-02-16","ABC");
            Node n6=new Node("G","0000001","2017-02-16","ABC");
            Node n7=new Node("H","0000011","2017-02-16","ABC");
            Node n8=new Node("I","0001000","2017-02-16","ABC");
            Node n9=new Node("J","0000100","2017-02-16","ABC");
            Node n10=new Node("K","0000010","2017-02-16","ABC");
            Node n11=new Node("L","1010101","2017-02-16","ABC");
            Node n12=new Node("M","1001011","2017-02-16","ABC");
            Node n13=new Node("N","1111111","2017-02-16","ABC");

            List<Node> listNode=new ArrayList<Node>();
            listNode.add(n1);
            listNode.add(n2);
            listNode.add(n3);
            listNode.add(n4);
            listNode.add(n5);
            listNode.add(n6);
            listNode.add(n7);
            listNode.add(n8);
            listNode.add(n9);
            listNode.add(n10);
            listNode.add(n11);
            listNode.add(n12);
            listNode.add(n13);

            int size=listNode.size();
            QueueNode queue=new QueueNode(7*size);

            for(int j=0;j<7;j++)
            {
                for (int i = 0; i < listNode.size(); i++) {

                    Node data=listNode.get(i);
                    String day=data.getDayOfWeek();
                    if(day.charAt(j)=='1')
                        queue.push(data);
                }

            }

            System.out.println(queue.pull().getMediName());
            System.out.println(queue.pull().getMediName());
            System.out.println(queue.pull().getMediName());
            System.out.println(queue.pull().getMediName());
            System.out.println(queue.pull().getMediName());
            System.out.println(queue.pull().getMediName());
            System.out.println(queue.pull().getMediName());
            System.out.println(queue.pull().getMediName());
            System.out.println(queue.pull().getMediName());
            System.out.println(queue.pull().getMediName());
            System.out.println(queue.pull().getMediName());
            System.out.println(queue.pull().getMediName());


        }

    }