public static DataList cursedReverse( DataNode node ) {
    if (node == null) 
        return new DataList();
    DataList dl = cursedReverse(node.next());
    dl.add(node);
    return dl;
}