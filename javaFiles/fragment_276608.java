public boolean isEmpty() {
   // Your logic here 
}

// Better have a public access because it seems an utility library and 
// it should be accessed from anywhere
public int pop() {

    StackNode temp = top;

    // update top
    top = belowTop;
    if (top == null) {
        throw new IllegalStateException("Can't pop from an empty stack");
    } 
    belowTop = top.link; // Now it works

    return temp.data;

}