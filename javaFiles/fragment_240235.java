ArrayList<BtreeNode> result = BtreeNode.asList(c);
    for (BtreeNode btreeNode : result) {
        System.out.println(btreeNode.data);
    }

// insert in sorted order
    c = result.get(0);
    for (int i = 1; i < result.size(); i++) {
        c.insOrd(c, result.get(i).data);
    }
    BtreeNode.print(c);