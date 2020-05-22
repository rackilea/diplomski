@Override
public void run(YourConfiguration configuration,
        Environment environment) throws Exception {
    ...
    environment.getObjectMapper().setSerializationInclusion(Include.NON_NULL);
}