GraphQLFieldDefinition field = ...;
Operation operation = Directives.getMappedOperation(field).get();

//Multiple methods can be hooked up to a single GraphQL operation. This gets the @Auth annotations from all of them
Set<Auth> allAuthAnnotations = operation.getResolvers().stream()
                .map(res -> res.getExecutable().getDelegate()) //get the underlying method
                .filter(method -> method.isAnnotationPresent(Auth.class))
                .map(method -> method.getAnnotation(Auth.class))
                .collect(Collectors.toSet());