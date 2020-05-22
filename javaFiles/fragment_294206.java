public static String deserializeToJSON(List<?> objList, String... removeAttributes) {
    List<DBObject> dbObjList = new ArrayList<>(objList.size());
    DBObject dbObj;
    for(Object obj :objList){
        dbObj = morph.toDBObject(obj);
        for(int i=0; i < removeAttributes.length; i++){
        debug("Removed DBObject filed: " +dbObj.removeField(removeAttributes[i]));                                    
        }
        dbObjList.add(dbObj);
    }             
    String json = JSON.serialize(dbObjList);
    return json;
}