TypeResolver t =  new TypeResolver() {
    @Override
    public GraphQLObjectType getType(TypeResolutionEnvironment env) {
        Object javaObject = env.getObject();
        if (javaObject instanceof Car) {
            return env.getSchema().getObjectType("Car");
        } else if (javaObject instanceof Airplane) {
            return env.getSchema().getObjectType("Airplane");
        } else {
            return env.getSchema().getObjectType("Car");
        }
    }
};