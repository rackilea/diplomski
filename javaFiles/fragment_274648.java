public <T> void getJsonObject(String res, RequestCallBack<T> callBack, Class<T> clazz) {
    T result;
    if (res != null) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            result = mapper.readValue(res, clazz);
            callBack.onSuccess(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}