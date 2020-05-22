public void addItem ( Treasure newItem ) {
    inventory.add ( newItem );
    addNode ( newItem.getType(), tNode );//Add Treasure parent Node labeled "Treasures"
}
public void addArtifact ( Artifact newItem ) {
    artifacts.add ( newItem );
    addNode ( newItem.getName(), aNode );//Add Artifact Node to parent Node labeled "Artifacts"
}