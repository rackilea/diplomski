public ParseStrategy createParser(){
  ParseStrategyProvider provider = ParseStrategyProvider.create();
  TopLevelParseStrategy topLevel = new TopLevelParseStrategy(provider);
  provider.registerStrategy("(", topLevel);

  // create and register all of your other parse strategies

  return topLevel;
}