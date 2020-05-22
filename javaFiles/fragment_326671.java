VisualRecognition service = new VisualRecognition(VisualRecognition.VERSION_DATE_2015_12_02);
 service.setUsernameAndPassword("*******", "********");

 File p1 = new File("/home/leoks/Desktop/models/pos2010-2011.zip");
 File n1 = new File("/home/leoks/Desktop/models/pos2014-2015.zip");
 VisualClassifier c1 = service.createClassifier("2010", p1, n1);

 File p3 = new File("/home/leoks/Desktop/models/pos2014-2015.zip");
 File n3 = new File("/home/leoks/Desktop/models/pos2010-2011.zip");
 VisualClassifier c3 = service.createClassifier("2014", p3, n3);

System.out.println(service.getClassifiers());