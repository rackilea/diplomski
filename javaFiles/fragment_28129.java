@AnalyzerDef(name = "TEXT_SORT",
        tokenizer = @TokenizerDef(factory = KeywordTokenizerFactory.class),
        filters = {
                @TokenFilterDef(factory = ASCIIFoldingFilterFactory.class),
                @TokenFilterDef(factory = LowerCaseFilterFactory.class),
                @TokenFilterDef(factory = PatternReplaceFilterFactory.class, params = {
                    @Parameter(name = "pattern", value = "('-&\\.,\\(\\))"),
                    @Parameter(name = "replacement", value = " "),
                    @Parameter(name = "replace", value = "all")
                }),
                @TokenFilterDef(factory = PatternReplaceFilterFactory.class, params = {
                    @Parameter(name = "pattern", value = "([^0-9\\p{L} ])"),
                    @Parameter(name = "replacement", value = ""),
                    @Parameter(name = "replace", value = "all")
                }),
                @TokenFilterDef(factory = TrimFilterFactory.class)
        }
    )