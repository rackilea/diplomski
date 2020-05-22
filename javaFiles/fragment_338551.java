@SuppressWarnings("unchecked")
    public <T>  List<T> getData(String classname, Class<T> pClass)
    {
       List<T> ob = querywithParams.list();
        return ob;
     }