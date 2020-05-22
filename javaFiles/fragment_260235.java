JCas jCas = JCasFactory.createJCas();

// the sample text to annotate
jCas.setDocumentText("Mark wants to buy CC234.");

// configure the engine with scripts and resources
AnalysisEngine rutaEngine = AnalysisEngineFactory.createEngine(
    RutaEngine.class, //
    RutaEngine.PARAM_RESOURCE_PATHS,
    "src/main/resources/ruta/resources",//
    RutaEngine.PARAM_SCRIPT_PATHS,
    "src/main/resources/ruta/scripts",
    RutaEngine.PARAM_MAIN_SCRIPT, "Example");

// run the script. instead of a jCas, you could also provide a UIMA collection reader to process many documents
SimplePipeline.runPipeline(jCas, rutaEngine);

// a simple select to print the matched Names
for (Name name : JCasUtil.select(jCas, Name.class)) {
    System.out.println(name.getCoveredText());
}