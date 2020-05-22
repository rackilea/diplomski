public static void main(final String... args) throws IOException, UIMAException, SAXException {
     final String note = "Serum Cholesterol 154 150 250 mgs/dl\n-\nSerum Triglycerides 67 90 200 mgs /dl\n-\nSerum HDL: Cholesterol 38 35 55 mgs /dl\n-\nSerum LDL: Cholesterol 49 85 150 mgs/d1\n-\nSerum VLDL: Cholesterol 13 10 40 mgs/dl\n-\nTotal Cholesterol / HDL Ratio: 3.90\";
     final JCas jcas = JCasFactory.createJCas();
     jcas.setDocumentText(note);

     final AnalysisEngineDescription aed = getFastPipeline(); 
     SimplePipeline.runPipeline(jcas, aed);
     CAS cas = jcas.getCas();
     JsonCasSerializer jcs = new JsonCasSerializer();
     jcs.setPrettyPrint(true); // do some configuration
     StringWriter sw = new StringWriter();
     jcs.serialize(cas, sw); // serialize into sw

     System.out.println(sw.toString());