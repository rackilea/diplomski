private Map<String, Object> executeGraphqlQuery(String operationName,
                                                String query, Map<String, Object> variables) {
    ExecutionInput executionInput = ExecutionInput.newExecutionInput()
            .query(query)
            .variables(variables)
            .operationName(operationName)
            .build();

    return graphql.execute(executionInput).toSpecification();
}