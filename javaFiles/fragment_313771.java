public static void registerProcedure(GraphDatabaseService db, Class<?>...procedures) throws KernelException {
    Procedures proceduresService = ((GraphDatabaseAPI) db).getDependencyResolver().resolveDependency(Procedures.class);
    for (Class<?> procedure : procedures) {
        proceduresService.registerProcedure(procedure);
        proceduresService.registerFunction(procedure);
    }
}