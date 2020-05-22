void width(Node node,int level){
    Map<Integer,Integer> mp = new HashMap<Integer,Integer>();
    widthImpl(mp, node, level);
    // find maximum
}

private void widthImpl(Map<Integer,Integer> mp, Node node, int level) {
    if(node==null)
        return;
    if(mp.containsKey(level)){
        int count = mp.get(level);
        mp.put(level, count+1);
    }else{
        mp.put(level, 1);
    }

    widthImpl(mp, node.left, level+1);
    widthImpl(mp, node.right, level+1);
}