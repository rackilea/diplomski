PCollection<KV<Integer, String>> input = p
  .apply("Create data", Create.of(
        KV.of(1, "{\"user\":\"Alice\",\"age\":\"22\",\"country\":\"Denmark\"}"),
        KV.of(1, "{\"income\":\"1500\",\"blood\":\"A+\"}"),
        KV.of(1, "{\"food\":\"pineapple pizza\",\"age\":\"44\"}"),
        KV.of(1, "{\"user\":\"Bob\",\"movie\":\"Inception\",\"income\":\"1350\"}"))
  );