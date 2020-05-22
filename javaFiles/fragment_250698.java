private int nTerm = 0; // field added by me

@Override
protected TokenStreamComponents createComponents(String fieldName) {
    final Tokenizer source = new StandardTokenizer();
    TokenStream result = new StandardFilter(source);
    result = new EnglishPossessiveFilter(result);
    result = new LowerCaseFilter(result);
    result = new StopFilter(result, stopwords);
    if (!stemExclusionSet.isEmpty())
        result = new SetKeywordMarkerFilter(result, stemExclusionSet);
    result = new PorterStemFilter(result);

    // my modification starts here:
    class ExamineFilter extends FilteringTokenFilter {
        private final CharTermAttribute termAtt = addAttribute(CharTermAttribute.class);
        public ExamineFilter( TokenStream in ) {
                super(  in);
          }         
        @Override
        protected boolean accept() throws IOException {
            String term = new String( termAtt.buffer(), 0, termAtt.length() );
            printOut( String.format( "# term %d |%s|", nTerm, term ));

            // do all sorts of things with this term... 

            nTerm++;
            return true;
        }
    }
    class MyTokenStreamComponents extends TokenStreamComponents {
        MyTokenStreamComponents( Tokenizer source, TokenStream result ){
            super( source, result );
        }
        public TokenStream getTokenStream(){
            // reset term count at start of each Document
            nTerm = 0;
            return super.getTokenStream();
        }
    }
    result = new ExamineFilter( result );
    return new MyTokenStreamComponents(source, result);
    //
}