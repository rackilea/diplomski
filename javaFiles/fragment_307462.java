static void displayTree(DTONodeDetail root ,int level){

    System.out.print(prefix(level));
    System.out.println(root.name);

    ArrayList<DTONodeDetail> children = selectChild(dto.getNodeId());

    for(DTONodeDetail child : children){
       displayTree(child, level + 1);
    }

}