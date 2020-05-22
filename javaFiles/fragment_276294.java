public static void main(String[] args) {

    String answer = "y";
    String n = null;
    char nodePointer = ' ';
    KeyboardReader reader = new KeyboardReader();

    Node start = NULL;
    Node last = NULL;
    Node temp = NULL;

    do{
        System.out.print("Enter a letter: ");
        nodePointer = reader.readChar();

        temp = new Node(nodePointer);
        temp.nodeptr = NULL;
        if (start == NULL) start = temp;
        if (last != NULL) last.nodeptr = temp;
        last = temp;

        System.out.print("Linked list: ");

        temp = start;
        while(temp != null){
            System.out.print(temp.letter);
            temp = temp.nodeptr;
        }
        addLine();

        System.out.print("Would you like to enter another letter (y/n)? ");
        n = reader.readLine();

        addLine();
    }while(answer.compareTo(n) == 0);

}