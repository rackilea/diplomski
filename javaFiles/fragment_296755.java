public T getData(String identifier, Class<? extends T> clazz) throws GeneralSecurityException, IOException {
    //do some stuff and get the content, which is a JSON 

    final T result = (T)JsonMapper.fromJsonToJavaObject(decryptedJson, clazz);

    return result;
}