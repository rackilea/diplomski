StringBuilder expressionBuilder = new StringBuilder();

    String separator = "";

    for (String s : listStrings) {
        expressionBuilder.append(separator + " label1 LIKE '%" + s + "%'");
        separator = " OR ";
    }

    String expression = expressionBuilder.toString();

    sentenceDataFrame = sentenceDataFrame.filter(expression);