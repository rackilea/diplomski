public static void main(String[] args) {

    char c[] = "ABCDEFGHIJ".toCharArray();
    int aryL = c.length;

    SimpleStack sS1 = new SimpleStack(aryL); // You have a stack with size 10;
    System.out.println(sS1.isEmpty()); // on index 0, will return true.
    sS1.push('A'); // Adds A to top of empty stack, tos = 1 after this line
    sS1.push('B'); // Adds B to top of empty stack, tos = 2 after this line
    sS1.push('C'); // Adds C to top of empty stack, tos = 3 after this line
    sS1.pop();     // Removes top of empty stack, tos = 2 after this line
    sS1.push('C'); // Adds C to top of empty stack, tos = 3 after this line

    // Stack now looks like:
    //  C 
    //  B
    //  A -> bottom of stack

}