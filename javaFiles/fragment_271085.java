public static void main(String[] args) {
    ScriptEngineManager mgr = new ScriptEngineManager();
    List<ScriptEngineFactory> factories =
            mgr.getEngineFactories();
    for (ScriptEngineFactory factory : factories) {
        String engName = factory.getEngineName();
        String engVersion = factory.getEngineVersion();
        String langName = factory.getLanguageName();
        String langVersion = factory.getLanguageVersion();
        System.out.printf("Script Engine: %s (%s)\n", engName, engVersion);
        System.out.printf("\tLanguage: %s (%s)\n", langName, langVersion);
    }
}