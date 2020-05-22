public class CreateLinkedList {

    public class Node {
        String playerName;
        Node next;
    }

    public static void main( String[] args ) {

        Node first = new CreateLinkedList().new Node();
        Node second = new CreateLinkedList().new Node();
        Node third = new CreateLinkedList().new Node();

        first.playerName = "Sanchez";
        second.playerName = "Ozil";
        third.playerName = "Welbeck";

        System.out.println( "First is : " + first.playerName );
        System.out.println( "Second is : " + second.playerName );
        System.out.println( "Third is : " + third.playerName );

    }
}