public static void main(String[] args){
    Tree t = new Tree();
    int nbCells = 9;
    t.setRoot(buildTree(new Board(nbCells), 0, -1));
}

public static Node buildTree(Board b, int player, int positionToPlay){
    if(player != 0){
        b.setCellAt(positionToPlay, player);
    }
    Node n = new Node(b, b.nbEmptyCells());

    int j = 0;
    for(int i = 0; i < b.nbCells(); i++){
        if(b.getCellAt(i) == 0)
            n.setChildAt(j++, buildTree(new Board(b), changePlayer(player), i));
    }

return n;
}

public static int changePlayer(int p){
    switch(p){
    case 0:
        return 1;
    case 1:
        return 2;
    case 2:
        return 1;
    default:
        return 0;
    }
}