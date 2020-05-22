static int max=-1;
static TrieNode maxNode=null;

static void dfs(TrieNode node, int depth){
    if(node.children.size()>1 && depth>max){
        max=depth;
        maxNode=node;
    }
    for (TrieNode tn: node.children.values())
        dfs(tn,depth+1);
}

public static void test(){
    TrieNode root = Tree.createTree();
    Tree.insertWord(root, "abcd");
    Tree.insertWord(root, "abcg");
    Tree.insertWord(root, "abckk");
    Tree.insertWord(root, "abf");
    dfs(root,0);
    System.out.println("Max node:"+maxNode.letter);
}