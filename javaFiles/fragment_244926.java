public void activate(ComponentContext context, Map<String, Object> properties) {
    try {
       ...
    } catch(Exception e) {
        context.disableComponent((String) properties.get(Constants.SERVICE_PID));
        // not sure if a CE is best here... Maybe just rethrow the original one
        throw new ComponentException("Some reason");
    }
}