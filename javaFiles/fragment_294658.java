public Object put(String arg0, Object arg1)
{
    //Error was being thrown in here added null check but I can't set the values
    if( _dao == null ) _dao = new BasicDBObject();
    return _dao.put( arg0, arg1 );
}