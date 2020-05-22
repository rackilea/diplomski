Configuration.setTaggerType("openNLP");
        Configuration.setSingleStrength(6);
        Configuration.setNoLimitStrength(5);
        // if tagger type is "openNLP" then give the openNLP POS tagger path
        //Configuration.setModelFileLocation("model/openNLP/en-pos-maxent.bin"); 
        // if tagger type is "default" then give the default POS lexicon file
        //Configuration.setModelFileLocation("model/default/english-lexicon.txt");
        // if tagger type is "stanford "
        Configuration.setModelFileLocation("Dont need that here");
        Configuration.setPipeline(pipeline);
        TermsExtractor termExtractor = new TermsExtractor();
        TermDocument topiaDoc = new TermDocument();
        topiaDoc = termExtractor.extractTerms(text);
        //logger.info("Extracted terms : " + topiaDoc.getExtractedTerms());
        Map<String, ArrayList<Integer>> finalFilteredTerms = topiaDoc.getFinalFilteredTerms();
        List<KeywordsModel> keywords = new ArrayList<>();
        for (Map.Entry<String, ArrayList<Integer>> e : finalFilteredTerms.entrySet()) {
            KeywordsModel keyword = new KeywordsModel();
            keyword.setLabel(e.getKey());
            keywords.add(keyword);
        }