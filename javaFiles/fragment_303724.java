public void addToRelationships(Relationship relationship) {
    if (this.relationships == null) {
       this.relationships = new ArrayList<Relationship>();
    }
    this.relationships.add(relationship);
    relationship.setPersonFrom(this);
}