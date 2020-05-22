for ( Node nodeOnPath : path.nodes() ) 
{
    Relationship rel = nodeOnPath.getSingleRelationship(MyTypes.LOVE,  Direction.INCOMING)   
    Node childNode = rel.getOtherNode(nodeOnPath)
    // process the childNode
}