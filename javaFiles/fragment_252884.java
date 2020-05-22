Processor proc = new Processor();
XQueryCompiler c = proc.newXQueryCompiler();
XQueryEvaluator q = c.compile($query).load();
List<XdmItem> urls = new ArrayList();
for (url : inputUrls) {
  urls.append(new XdmAtomicValue(url);
}
q.setExternalVariable(new QName("urls"), new XdmValue(urls));
q.setDestination(...)
run();