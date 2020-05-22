import java.io.*;

class Main {

/**
 * @param args the command line arguments
 * @throws java.io.IOException
 */

public static void main(String[] args) throws IOException 
{
    int count = 0;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    DoublyLinkedList list = new DoublyLinkedList();//does this go in the loop?
    System.out.println("Enter a String, then press enter.");
    String inputString = br.readLine();
    while ((inputString != null) )
    {
        if (inputString.equals("-1")) 
        {
          break;
        } 
        else 
        {
          list.insertFirst(inputString);
        } 
       inputString =br.readLine();
       count++;
  }

  displayList(list);
  br.close();
}

public static void displayList(DoublyLinkedList d) 
    {

    Node node = d.first;

        while(node != null)
        {

            node.displayNode();

            //System.out.println("Next Link: " + node.next);

            node = node.next;

            System.out.println();

        }

    }  

}