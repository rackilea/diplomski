BDD bddManager = new BDD(1000,100);

private int variablesDefinition;
private int[][] variables;

private void createVariables(int maxVariableCount) {
    variables = new int[variablesDefinition][maxVariableCount];
    for(int i = 0; i < variables.length; i++) {
        for(int j = 0; j < maxVariableCount; j++) {
            variables[i][j] = bddManager.createVar();
        }
    }
}