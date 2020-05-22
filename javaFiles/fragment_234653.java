public void testMethod(List<String> prop1, EmailJson randomModel){
    prop1.stream().forEach(s -> {
        if(randomModel.getSomeList()
                      .removeIf(model -> model.getSomeProp().equalsIgnoreCase(s)))
            LOGGER.info(() -> "there were matches of: "+s);
    });
}