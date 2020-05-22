@Override
public T convert(Class<T> type, Object value) {
    if ((type.equals(String.class)) && ... ) {
        //     casting here
        return type.cast( conevertDataToJSONString((Data) value) );
    } 
    ...
}

// no need to make this method generic
private String conevertDataToJSONString(Data data) {
    return gson.toJson(data);
}