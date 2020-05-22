ExternalSpreadsheetCompiler converter = new ExternalSpreadsheetCompiler();
String drl = converter.compile(spreadsheetStream, ruleTemplateStream, 1, 1);
KieServices kieServices = KieServices.Factory.get();
KieFileSystem kfs = kieServices.newKieFileSystem();
kfs.write("src/main/resources/simple.drl", kieServices.getResources().newReaderResource(new StringReader(drl)));
KieBuilder kieBuilder = kieServices.newKieBuilder(kfs).buildAll();
KieContainer kieContainer = kieServices.newKieContainer(kieBuilder.getKieModule().getReleaseId());
KieSession kieSession = kieContainer.newKieSession();