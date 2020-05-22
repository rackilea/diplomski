String rutaRule = "STRING id;"
        + "STRING part1Id;"
        + "STRING part2Id;"
        + "Sentence{->GETFEATURE(\"matchId\", id)};"
        + "part1{->GETFEATURE(\"parent\", part1Id)};"
        + "part2{->GETFEATURE(\"parent\", part2Id)};"
        + "Sentence{AND(IF(id == part1Id), IF(id == part2Id))-> NewAnnotation} <-"
        + "{part1<-{Constituent.label == \"VBD\";} % "
        + "part2<-{Constituent.label == \"MD\" # Constituent.label == \"VBN\";};};";

Ruta.apply(cas,rutaRule);