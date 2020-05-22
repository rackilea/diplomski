String aux = "";    
MustacheFactory mf = new DefaultMustacheFactory();
    Mustache mustache = mf.compile("path/to/file.html");
    StringWriter stringWriter = new StringWriter();
    mustache.execute(stringWriter, wrapper);
    aux = stringWriter.toString();
    System.out.println(aux);