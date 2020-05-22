PluginParameterExpressionEvaluator expressionEvaluator = new PluginParameterExpressionEvaluator(session, mojoExecution);
    PlexusConfiguration pomConfiguration = new XmlPlexusConfiguration(mojoExecution.getConfiguration());

    for (PlexusConfiguration plexusConfiguration : pomConfiguration.getChildren()) {
        String value = plexusConfiguration.getValue();
        String defaultValue = plexusConfiguration.getAttribute("default-value");
        try {
            String evaluated = defaultIfNull(expressionEvaluator.evaluate(defaultIfBlank(value, defaultValue)), "").toString();
            System.out.println(plexusConfiguration.getName() + " -> " + defaultIfBlank(evaluated, defaultValue));
        } catch (ExpressionEvaluationException e) {
            e.printStackTrace();
        }
    }