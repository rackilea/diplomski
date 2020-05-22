@Factory
    public Query getFilter() {
        String valueToMatch = this.avisDefinitifCet.toLowerCase();
        return new BooleanQuery.Builder()
            .add(new TermQuery(new Term("avisDefinitifCet", valueToMatch)), Occur.SHOULD)
            .add(new TermQuery(new Term("clasCet1ErPassage", valueToMatch)), Occur.SHOULD)
            .build();
    }