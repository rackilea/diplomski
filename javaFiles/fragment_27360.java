public void method() throws IOException, CustomException {
    try {
        //Body of the method
    } catch (IllegalArgumentException | InstantiationException | IllegalAccessException e) {
        throw new CustomException(e);
    }
}