public ArrayList<Integer> makePathList(AbstractTree<String> tree){
    StringBuilder buffer = new StringBuilder();
    ArrayList<Integer> pl = new ArrayList<Integer>();
    ArrayList<StringBuilder> paths = getPaths(tree, buffer);
    for(StringBuilder sb : paths){
        pl.add(sb.toString().hashCode());
    }

    return pl;
}

public ArrayList<StringBuilder> getPaths(AbstractTree<String> tree, StringBuilder parent){

    ArrayList<StringBuilder> list = new ArrayList<StringBuilder>(); 
    parent.append("/");
    parent.append(tree.getNodeName());
    list.add(new StringBuilder(parent));
    if (!tree.isLeaf()){

        int i = 0;
        Iterator<AbstractTree<String>> child = tree.getChildren().iterator();
        while (i < tree.getChildren().size()){

            list.addAll(getPaths(child.next(), new StringBuilder(parent)));
            i++;
        }  
    }
    return list;
}

public HashSet<Integer> createShingleSet(ArrayList<Integer> paths, int shingleLength){
    HashSet<Integer> shingleSet = new HashSet<Integer>();
    for(int i = 0; i < paths.size(); i += shingleLength){
        Multiset<Integer> set = new Multiset<Integer>();
        for(int j = 0; j < shingleLength; j++){ 
            if (i + j < paths.size())
              set.add(paths.get(i + j));    
        }
        shingleSet.add(set.hashCode()); 
    }
    return shingleSet;
}