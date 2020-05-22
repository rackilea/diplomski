private Binding createBinder(final Supplier<String> lambda) {
    return Bindings.createStringBinding(() -> {
        if(webService.getLastValue() != null){
            return lambda.get();
        } else{
            return "";
        }
    }
}