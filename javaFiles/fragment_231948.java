public static MyObj getMyObj() {
    return MyObjHolder.obj;
}

private static class MyObjHolder {
    static final MyObj obj = new MyObj();
}