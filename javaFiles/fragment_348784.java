private int pointerToTheTopmostElement = 0; // increase when pushed, decrease when poped

public int pop(){
    int popingElement = pointerToTheTopmostElement;
    pointerToTheTopmostElement--;
    return stack[popingElement];
}