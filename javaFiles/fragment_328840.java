HERMEntityRelationshipType parseERType(DBMEntityRelationshipType   dbmERType){
    if(dbmERType.getClass().equals(DBMEntityType.class)) {
        return new HERMEntityType(dbmERType);
    } else {
        return new HERMRelationshipType(dbmERType);
    }

}