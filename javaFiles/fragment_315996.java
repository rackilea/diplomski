DocumentAssembler docAssembler = (DocumentAssembler) new DocumentAssembler().setInputCol("column1")
                .setOutputCol("document");

Tokenizer tokenizer = (Tokenizer) ((Tokenizer) new Tokenizer().setInputCols(new String[] { "document" }))
                .setOutputCol("token");
String[] inputCols = new String[] { "token", "document" };

ViveknSentimentModel sentiment  = (ViveknSentimentModel) ViveknSentimentModel
.load("/path/to/pretained model folder");

Pipeline pipeline = new Pipeline().setStages(new PipelineStage[] { docAssembler, tokenizer, sentiment });

// Fit the pipeline to training documents.
PipelineModel pipelineFit = pipeline.fit(ds);
ds = pipelineFit.transform(ds);