@Override
  public void init(SolrParams args) {
    super.init(args);
    similarity = new PerFieldSimilarityWrapper() {
      @Override
      public Similarity get(String name) {
        FieldType fieldType = core.getLatestSchema().getFieldTypeNoEx(name);
        if (fieldType == null) {
          return defaultSimilarity;
        } else {
          Similarity similarity = fieldType.getSimilarity();
          return similarity == null ? defaultSimilarity : similarity;
        }
      }
    };
  }