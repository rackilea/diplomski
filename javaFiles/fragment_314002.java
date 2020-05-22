String URL = "remote:localhost/localDBDocumentAPI";
String functionName = "funfun";
try (ODatabaseDocumentTx db = new ODatabaseDocumentTx(URL)) {
    db.open("admin", "admin");
    OFunction f = new OFunction();
    f.setName(functionName);
    f.setLanguage("javascript");
    f.setParameters(new ArrayList());
    f.setCode("print(\"hellooo\\n\");");
    f.save();
}

try (ODatabaseDocumentTx db = new ODatabaseDocumentTx(URL)) {
    db.open("admin", "admin");
    OFunction f = db.getMetadata().getFunctionLibrary().getFunction(functionName);
    f.execute();
}

try (ODatabaseDocumentTx db = new ODatabaseDocumentTx(URL)) {
    db.open("admin", "admin");
    OFunction f = db.getMetadata().getFunctionLibrary().getFunction(functionName);
    db.command(new OCommandScript("javascript", f.getCode())).execute();
}