public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
    int nbEntries = in.readInt();
    Entity[] entities = new Entity[nbEntries];
    for(int i = 0; i < nbEntries; i++) {
        Entity entity = new Entity(0);
        relation.readExternal(in);
        entities[i] = entity;
    }
}