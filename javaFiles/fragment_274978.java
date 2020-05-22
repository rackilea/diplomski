public static void main(String[] args) {
        //test cases
        Node test = new Node(0);
        for(int i = 1; i <= 20; i++) {
            test.appendToTail(i);
        }

        test.printNode();

        for(int i = 0; i <= 20; i = i + 2) {
            test = test.deleteNode(test, i);
        }

        test.printNode();


    }