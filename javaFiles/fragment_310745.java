Node root = new Node(5);
    for(int i = 0 ; i < 10 ; i++){
        if(i == 5) continue;
        root.insertNode(i);
    }

root = null;