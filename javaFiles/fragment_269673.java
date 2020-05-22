//this constructor will be called for whenever creating objects via   reflection from a ResultSet    
 public DBObject(ResultSet rs) throws EasyORMException{
    try{
        for (int i=1;i<=rs.getMetaData().getColumnCount();i++) {
            Object obj=rs.getObject(i);
            if(obj instanceof Clob){
                cachedResults.put(rs.getMetaData().getColumnName(i), clobToString((Clob)obj));
            }else if(obj instanceof Blob){
                cachedResults.put(rs.getMetaData().getColumnName(i), (Blob)obj);
            }else if(obj instanceof String && stringEncoding != null ) {
                try{
                    cachedResults.put(rs.getMetaData().getColumnName(i), new String(((String)obj).getBytes(stringEncoding),stringEncoding));
                }catch(UnsupportedEncodingException e){
                    throw new EasyORMException(e);
                }
            }else{
                cachedResults.put(rs.getMetaData().getColumnName(i), obj);
            }

        }
    }catch (Exception e) {
        throw new EasyORMException(e);
    }
}