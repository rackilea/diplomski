DataSet set = new DataSet("ds");
set.readXml(MyDir + "in.xml");

Document doc = new Document(MyDir + "template.docx");
ReportingEngine engine = new ReportingEngine();
engine.buildReport(doc, set.getTables().get("root").getRows().get(0), "ds");//model

doc.save(MyDir + "output.docx");