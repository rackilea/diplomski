private static Node<Integer> createTree(Expression expression) {
    Stack<Node<Integer>> nodeStack = new Stack<>();
    // ...
    } else if (token instanceof Element) {
         nodeStack.push(new Node<Integer>(((Element) token).value)); // Here
    }
    // ...
            Node<Integer> right = nodeStack.pop();
            Node<Integer> left = nodeStack.pop();
            Node<Integer> node = nodeStack.pop();
    // ...
    }
}