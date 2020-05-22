for(int i=0; i < numVariables; i++){
        for(int j=0; j < numRules+1; j++){
            if (variables[i][j] == null)
                break;
            System.out.printf("%s ", variables[i][j]);
        }
    }