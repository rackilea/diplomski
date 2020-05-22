class SimpleAnalyzer extends Analyzer {

        protected NormalizeCharMap charConvertMap;

        protected void setCharConvertMap() {

            NormalizeCharMap.Builder builder = new NormalizeCharMap.Builder();
            builder.add("&","and");
            charConvertMap = builder.build();
        }

        public SimpleAnalyzer() {
            setCharConvertMap();
        }

        @Override
        protected TokenStreamComponents createComponents(String fieldName, Reader reader) {
            Tokenizer source = new MusicbrainzTokenizer(Version.LUCENE_35,
                    reader);
            TokenStream filter = new LowerCaseFilter(Version.LUCENE_35,source);
            return new TokenStreamComponents(source, filter);
        }

        @Override
        protected Reader initReader(String fieldName,
                                    Reader reader)
        {
            return new MappingCharFilter(charConvertMap, reader);
        }
    }