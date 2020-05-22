private static TreeSet<Node> nodelist = new TreeSet<Node>(
        new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if ( o1.isValid == o2.isValid ) {
                    // Both valid/invalid - it's the totals that control the order.
                    return o1.totalVal - o2.totalVal;
                } else {
                    // One valid, one not, move all invalids to one end.
                    return o1.isValid ? -1 : 1;
                }
            }
        });