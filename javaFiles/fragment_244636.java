public  void getCdtion( String arff_path) throws Exception{

    ArffLoader arffloder = new ArffLoader();
    arffloder.setFile(new File(arff_path));
    Instances structure = arffloder.getStructure();
    Attribute classAtt = structure.classAttribute();

    System.out.println(classAtt);

}