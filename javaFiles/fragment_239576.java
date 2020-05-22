class CollectionCustomClass<T> extends ArrayList<CustomClass>{

    public CustomClass find(Class<T> clazz) {
        for(int i=0; i< this.size(); i++)
        {
            CustomClass obj = get(i);
            if(obj.getClass() == clazz)
            {
                return obj;
            }
        }
        return null;
    }
 }