public Object method() {
    Object resultCode = "success";
    if (something) {
        resultCode = new StrutsResultSupport();
    }
    return resultCode ;
}