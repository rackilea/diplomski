public static class Node{
    int level;
    List<Node> children = new ArrayList<Node>();
    Node(int level){ this.level = level;}
}

public static void main (String[] args) throws java.lang.Exception{
    String[] h = {"H1", "H1", "H2", "H3", "H3", "H5", "H2", "H2", "H3", "H4",
                  "H2", "H2", "H2", "H1", "H2", "H2", "H3","H4", "H4", "H2"};

    Node[] mostRecent = new Node[6];                      // 5 headers + 1 root tag.
    mostRecent[0] = new Node(0);                          // root tag (level = 0)

    for(int i = 0; i < h.length; i++){
        int level = Integer.parseInt(""+h[i].charAt(1));  // get tag's "level"
        Node n = new Node(level);                         // create Node for tag
        mostRecent[level] = n;                            // update most recent tag

        int pLevel = level - 1;                          
        while(mostRecent[pLevel] == null) --pLevel;       // find nearest parent
        mostRecent[pLevel].children.add(n);               // append tag Node to parent

        for(int j = 1; j < level; j++)                    // print tag with indention
            System.out.print("\t");
        System.out.println(h[i]);
    } 
}