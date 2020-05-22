interface BaseScriptInfoParserFactory {
  /**
   * Calls the BaseScriptInfoParser constructor, with other constructor params
   * injected from the graph.
   */
  BaseScriptInfoParser create(Asset.ScriptKindEnum scriptKind);
}