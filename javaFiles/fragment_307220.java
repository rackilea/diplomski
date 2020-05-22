// create attributes. For nominal attributes list all possible values
ArrayList<Attribute> attributes = new ArrayList<Attribute>();
attributes.add(new Attribute("L1", new ArrayList<String>(Arrays.AsList("L1_val1", "L1_val2", ...)));
attributes.add(new Attribute("L2", new ArrayList<String>(Arrays.AsList("L2_val1", "L2_val2", ...)));
attributes.add(new Attribute("A"));
attributes.add(new Attribute("B"));
attributes.add(new Attribute("C"));
attributes.add(new Attribute("D"));
attributes.add(new Attribute("Station", new ArrayList<String>(Arrays.AsList("S1", "S2", ...)));

//create Instances
Instances ins = new Instances(name, attributes, traindata.size());

//create Instance
for(int i=0; i<traindata.size(); i++) {
    String L1 = traindata.get(i).getL1();
    String L2 = traindata.get(i).getL2();
    String station = traindata.get(i).getStation();

    double[] row = new double[] { 
        attributes.get(0).indexOfValue(L1), //convert string to double - index of L1
        attributes.get(1).indexOfValue(L2), //convert string to double - index of L2
        traindata.get(i).getA(), 
        traindata.get(i).getB(), 
        traindata.get(i).getC(), 
        traindata.get(i).getD(), 
        attributes.get(1).indexOfValue(station), //convert string to double  
     };
    Instance instance = new DenseInstance(weight, row);
    instances.add(instance);
 }

//build classifier
classifier.buildClassifier(instances);