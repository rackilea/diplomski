ProcessBuilder builder = new ProcessBuilder(
    "java",
    "-jar",
    "filePath/rdfslice_1.6.jar",
    "-source",
    "filePath/myData.nt",
    "-patterns",
    "{?s1 <http://www.europeana.eu/schemas/edm/isShownAt> ?o1.}",
    "-out",
    "filePath/output.out",
    "-order",
    "S");

Process p = builder.inheritIO().start();