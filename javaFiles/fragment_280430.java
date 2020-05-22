from(SOURCE_INPUT_PATH).
 .split().tokenize(System.lineSeparator())
   unmarshal(bindyFixed).
   marshal().
   xstream().
   to(SOURCE_OUTPUT_PATH).log("Finished Transformation").end();