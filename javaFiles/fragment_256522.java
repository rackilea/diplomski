private Object getMyObjectOrReturnClassAObject(Object param1) {
    try {
        return tryToGetObject(param1).orElse(new ClassA("it's null"));
    catch(ParamNotValidException e) {
        return new ClassA("param1 is not valid");
    }
}