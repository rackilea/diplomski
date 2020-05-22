Stack<In> myStack = new Stack<int[]>();
    myStack.push( new IntArray (new int[]{1,2}) );
    myStack.push( new IntArray (new int[]{1,3}) );
    myStack.push( new IntArray (new int[]{1,4}) );
    if (myStack.contains( new IntArray (new int[]{1,3})) ) {
        System.out.println("YES");
    } else {
        System.out.println("NO");
    }