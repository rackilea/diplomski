List<ProcessInstance> processInstances =
            runtimeService.createProcessInstanceQuery()
                    .processDefinitionKey(processKey)
                    .active()
                    .list();
    processInstances.forEach(processInstance -> {
        List<Execution> executions = runtimeService.createExecutionQuery()
                .processInstanceId(processInstance.getId())
                .list();
        executions.forEach(execution -> {
            runtimeService.setVariable(execution.getId(), variableName, variableValue);
        });
    });