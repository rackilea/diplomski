File image = new File("...");

 VisualClassifier vc1 = new VisualClassifier("2010_633980596");
 VisualClassifier vc2 = new VisualClassifier("2014_450835300");
 VisualClassification result = service.classify(image, vc1,vc2);
 System.out.println(result);