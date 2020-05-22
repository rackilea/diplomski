String INDEX_APPENDIX = "_IDX";
String VECTOR_APPENDIX = "_VEC";
ArrayList<PipelineStage> stages = new ArrayList<>();

for (String column : Arrays.asList("col1", "col2" )) {
        stages.add(new StringIndexer().setInputCol(column).setOutputCol(column + INDEX_APPENDIX));
        stages.add(new OneHotEncoder().setInputCol(column + INDEX_APPENDIX).setOutputCol(column +
                VECTOR_APPENDIX));
    }

Pipeline pipeline = new Pipeline()
    .setStages(stages.toArray(new PipelineStage[stages.size()]));

Dataset<Row> processedDf = pipeline.fit(df).transform(df);