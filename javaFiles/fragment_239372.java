public List<ResultObject> compareFields(SampleObject object) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException{
    List<ResultObject> resultList = new ArrayList<ResultObject>();      
    Field[] fields = this.getClass().getDeclaredFields();

    for(Field field : fields){
        if(!field.get(this).equals(field.get(object))){
            ResultObject resultObject = new ResultObject();
            resultObject.setFieldName(field.getName());
            resultObject.setOldObjectValue(field.get(this).toString());
            resultObject.setNewObjectValue(field.get(object).toString());
            resultList.add(resultObject);
        }
    }
    return resultList;
}