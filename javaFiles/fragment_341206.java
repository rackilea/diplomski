PCollection<KV<String, TableRow>> inputClassifiedKeyed = inputClassified
            .apply(ParDo.named("Actuals : Keys").of(new ActualsRowToKeyedRow()));

  PCollection<KV<String, Iterable<Map<String, String>>>> groupedCategories = p
  [...]
   .apply(GroupByKey.create());