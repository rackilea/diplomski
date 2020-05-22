@Override
  public void init(SolrParams params) {
    super.init(params);
    discountOverlaps = params.getBool("discountOverlaps", true);
    basicModel = parseBasicModel(params.get("basicModel"));
    afterEffect = parseAfterEffect(params.get("afterEffect"));
    normalization = parseNormalization(
        params.get("normalization"), params.get("c"), params.get("mu"), params.get("z"));
  }