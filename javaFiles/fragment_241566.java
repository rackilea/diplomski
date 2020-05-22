addPez(stack1);
    removeGreen(stack1);
    printStack(stack1); //stack2 is not defined and remove println statement
}

public static void addPez(Stack stack1) {//make addPez as static
    stack1.push("yellow");
    stack1.push("red");
    stack1.push("green");
    stack1.push("green");
    stack1.push("yellow");
    stack1.push("yellow");
    stack1.push("red");
    stack1.push("green");
}

public static void removeGreen(Stack stack1) {
    Stack temp = new Stack();
    while (!stack1.isEmpty()) {
        String check = (String) (stack1.pop());
        if (check.equals("green")) {
            //stack1.pop();
        } else {
            temp.push(check);
        }
    }
    //Stack stack2 = new Stack();
    while (!temp.isEmpty()) {
        String tmp = (String)temp.pop();
        stack1.push(tmp);
    }
}

public static void printStack(Stack stack1) {
    Stack xerox = (Stack)stack1.clone();
    while (!xerox.isEmpty()) {
        System.out.println(xerox.pop());
    }
}