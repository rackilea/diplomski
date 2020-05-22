public static class MultiTermUseIdfOfSearchTerm<Q extends Query> extends TopTermsRewrite<BooleanQuery> {

    //public static final class MultiTermUseIdfOfSearchTerm extends TopTermsRewrite<BooleanQuery> {
        private final Similarity similarity;

        /**
         * Create a TopTermsScoringBooleanQueryRewrite for
         * at most <code>size</code> terms.
         * <p>
         * NOTE: if {@link BooleanQuery#getMaxClauseCount} is smaller than
         * <code>size</code>, then it will be used instead.
         */
        public MultiTermUseIdfOfSearchTerm(int size) {
            super(size);
            this.similarity = new DefaultSimilarity();

        }

        @Override
        protected int getMaxSize() {
            return BooleanQuery.getMaxClauseCount();
        }

        @Override
        protected BooleanQuery getTopLevelQuery() {
            return new BooleanQuery(true);
        }

        @Override
        protected void addClause(BooleanQuery topLevel, Term term, float boost) {
            final Query tq = new ConstantScoreQuery(new TermQuery(term));
            tq.setBoost(boost);
            topLevel.add(tq, BooleanClause.Occur.SHOULD);
        }

        protected float getQueryBoost(final IndexReader reader, final MultiTermQuery query)
                throws IOException {
            float idf = 1f;
            float df;
            if (query instanceof PrefixQuery)
            {
                PrefixQuery fq = (PrefixQuery) query;
                df = reader.docFreq(fq.getPrefix());
                if(df>=1)
                {
                    idf = (float)Math.pow(similarity.idf((int) df, reader.numDocs()),2);
                }
            }
            return idf;
        }

        @Override
        public BooleanQuery rewrite(final IndexReader reader, final MultiTermQuery query) throws IOException {
            BooleanQuery  bq = (BooleanQuery)super.rewrite(reader, query);

            float idfBoost = getQueryBoost(reader, query);
            Iterator<BooleanClause> iterator = bq.iterator();
            while(iterator.hasNext())
            {
                BooleanClause next = iterator.next();
                next.getQuery().setBoost(next.getQuery().getBoost() * idfBoost);
            }
            return bq;
        }

    }