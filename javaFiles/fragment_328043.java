void printLevelOrderFixed() {
    List<Node> currLevel = new ArrayList<>();
    currLevel.add(root);

    int level = 1;
    while(currLevel.size() > 0) {

        // Output
        currLevel.forEach(x -> System.out.print(x + " "));

        // Preparation for next level
        List<Node> nextLevel = new ArrayList<>();
        for (int i = currLevel.size() - 1; i >= 0; i--) {
            Node left = currLevel.get(i).left;
            Node right = currLevel.get(i).right;

            if (level % 2 == 0) {
                if (left != null) nextLevel.add(left);
                if (right != null) nextLevel.add(right);                    
            } else {
                if (right != null) nextLevel.add(right);    
                if (left != null) nextLevel.add(left);
            }
        }
        currLevel.clear();
        currLevel.addAll(nextLevel);

        level++;
    }
    System.out.println("");
}