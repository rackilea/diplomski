public <T> List<T> getRecordsForSingleTable( Class<? extends DBObject> target, int startRecord, int countRecord,String orderByColumn ) throws EasyORMException {
    T obj=null;
    ResultSet rs=null;
    PreparedStatement stmt=null;
    AnnotationUtil.checkTableAnnotation(target);
    List<T> objList = new ArrayList<T>();
    countRecord = (countRecord<=0)?recNum:countRecord;
    startRecord = (startRecord<0)?0:startRecord;
    String qualifiedName = dbSchema!=null?dbSchema+"."+target.getAnnotation(TableInfo.class).tableName():target.getAnnotation(TableInfo.class).tableName();
    String query=null;
    if(orderByColumn!=null&&!orderByColumn.isEmpty())
        query=modifyQuery(qualifiedName, startRecord, countRecord, orderByColumn);
    else
        query="SELECT * FROM "+qualifiedName;
    try{
        sqlQuery = query;
        stmt=conn.prepareStatement(query);
        rs = stmt.executeQuery();

        while(rs.next()){
            obj = (T) target.getConstructor(ResultSet.class).newInstance(rs);
            ((DBObject)obj).setConnection(conn);
            objList.add(obj);
        }
    }catch(Exception e){
        throw new EasyORMException(e);
    } finally{
        closeResources(rs,stmt);
    }
    return objList;
}