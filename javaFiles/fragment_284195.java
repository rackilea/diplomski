sparkSession
    .read()
    .option("sep", ";")
    .option("quote", "\"")
    .option("multiLine", "true")
    .option("ignoreLeadingWhiteSpace", true)
    .csv(path.toString());