HashMap<Integer, List<Integer>> tree = new HashMap<Integer, List<Integer>>();

for (String line: input){
    String ints = line.split(" - ");
    Integer k = Integer.valueOf(ints[0]);
    Integer v = Integer.valueOf(ints[1]);
    List<Integer> children = tree.get(k);
    if (children == null){
        children = new ArrayList<Integer>();
        tree.put(k,children);
    }
    children.add(v);

    printIt(135, 0, tree);
}

 public static void printIt(Integer node, Integer depth, HashMap<Integer, List<Integer>> tree){
    System.out.println(getSpaces(depth) +"+ "+node);
    if (tree.containsKey(node)){
        for (Integer n : tree.get(node)){
            printIt(n, depth+1, tree);
        }
    }
}
public static String getSpaces(int depth){
    StringBuilder sb = new StringBuilder();
    for (int i=0;i<depth;i++){
        sb.append("  ");
    }
    return sb.toString();
}