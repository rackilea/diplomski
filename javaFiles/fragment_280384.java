public String findTableName(String columnName)
{
    boolean found=false;
    Map<String, ClassMetadata> classMetaData =  sessionFactory.getAllClassMetadata();
    for (Entry<String, ClassMetadata> metaData : classMetaData.entrySet()) 
    {
        String[] propertyNames = metaData.getValue().getPropertyNames();                    
        for (String property : propertyNames) 
        {           
            if(property == columnName)
            {
                return metaData.getKey() + "." + property;    
                found=true;
                break;
            }
        }
        if(found)
            break;
    }       
}