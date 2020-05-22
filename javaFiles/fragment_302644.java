protected void perfromCall(Class<?> expectedException) throws Exception {
    try {
        response = call.call(request);
    } catch (Exception e) {
        if (!expectedException.isInstance(e)) {
            throw e;
        }
    }
}