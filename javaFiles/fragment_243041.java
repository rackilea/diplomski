AnalysisEngineDescription heidelTime = createEngineDescriptionFromPath(
            "src/main/resources/desc/annotator/HeidelTime.xml");
            builder.add(heidelTime);

AnalysisEngineDescription intervalTagger = createEngineDescriptionFromPath(
            "src/main/resources/desc/annotator/IntervalTagger.xml");
            builder.add(intervalTagger);