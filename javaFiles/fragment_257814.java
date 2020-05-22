FunctionScoreQueryBuilder.FilterFunctionBuilder[] filterFunctionBuilders = new FunctionScoreQueryBuilder.FilterFunctionBuilder[]{
                new FunctionScoreQueryBuilder.FilterFunctionBuilder(
                        QueryBuilders.matchQuery(FIELD_TYPE, fieldType),
                        ScoreFunctionBuilders.weightFactorFunction(3)
                ),
                new FunctionScoreQueryBuilder.FilterFunctionBuilder(
                        ScoreFunctionBuilders.scriptFunction(format("doc['%s'].value", FIELD_COUNT))
                )
        };