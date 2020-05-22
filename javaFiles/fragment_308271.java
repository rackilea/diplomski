public class Stack {
    private List<String> stack = new ArrayList<String>();

    public void push(String element){
        stack.add(element);
    }

    public List<String> add(String newHead){
        stack = new ArrayList<String>(stack); // you should do "stack = new someList<E>(newHead, this);"
        return stack; // return the new stack
    }

    public String pop() {
        String res = stack.get(stack.size() - 1);
        stack.remove(stack.size() - 1); // 
        return res;
    }

    public void printStack() {
        System.out.println("TOS (Top Of Stack)");
        for(int i = stack.size() - 1; i >= 0; i--)
            System.out.println(stack.get(i));
        System.out.println("EOS (End Of Stack)");
    }
}

// Test it
...
String a = "a", b = "b";
Stack stck = new Stack();

stck.push(a);
stck.push(b);
stck.push(b);
stck.push(a);
stck.pop();

stck.printStack();
...