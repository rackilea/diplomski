public void readCoNLL(String inputFile) throws Exception {
    TSVReader reader = new TSVReader(0, 1, 2, 4, 5, 6, 7);
    reader.open(new FileInputStream(inputFile));
    DEPTree tree;
    while ((tree = reader.next()) != null)
        System.out.println(tree.toString(DEPNode::toStringDEP));
}