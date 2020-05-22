Context context = new Context();
String query = "declare variable $xml-file as xs:string external;" +
               "for $doc in collection('db') return deep-equal($doc, doc($xml-file))";
QueryProcessor proc = new QueryProcessor(query, context);
proc.bind("xml-file", xmlFile);
Result result = proc.execute(); // your result
proc.close();
context.close();