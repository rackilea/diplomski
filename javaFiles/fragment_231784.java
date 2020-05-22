val normal =
  email.
    ...
    mapPartitions {
      bodies => 
        lazy val parser = new PrettyTimeParser
        for (body <- bodies) yield
          (body, DateTimeParser.normalizeBody(body, parser)))
    }.
    ...