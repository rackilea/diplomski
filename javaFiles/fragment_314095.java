Set<RequestMappingInfo> rmSet = handlerMapping.getHandlerMethods().keySet();
for (RequestMappingInfo rm : rmSet) {

    if("[YourURLPath]".equals(rm.getPatternsCondition().toString())) {
        // URL mapping matched 
    }
}