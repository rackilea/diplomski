private RootNode makeData()
{
    RootNode rootNode = new RootNode();
    rootNode.setName("Root");
    for (int i = 0; i < 20; i++)
    {
        NodeOne nodeOne = new NodeOne();
        nodeOne.setName("One Node 0b" + Integer.toBinaryString(i));
        rootNode.getNodes().add(nodeOne);
        for (int j = 0; j < 20; j++)
        {
            NodeTwo nodeTwo = new NodeTwo();
            nodeTwo.setDescription("Another node #" + j);
            nodeTwo.setName("0x" + Integer.toHexString(j));
            nodeOne.getNodes().add(nodeTwo);
        }
    }
    return rootNode;
}