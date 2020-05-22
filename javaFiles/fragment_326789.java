data = new Object[<some value>][3];

for(int i = 0; i < al.size(); i++){
    csvFile = directoryPath + al.get(i);
    System.out.println("csvFile-===="+csvFile);
    log.info("Loading data provider TestCaseInformation...");
    ArrayList<ArrayList<String>> lines=readCSVFile(csvFile);
    int testSize = lines.size();
    log.info("Test file has {} tests contained within it." ,testSize);
    for ( int k=0;k<lines.size();k++ ) {
        ArrayList line=lines.get(k);
        System.out.println("K values is "+k);
        List testData=new ArrayList();
        List validationData=new ArrayList();

        testData=line.subList(line.indexOf("IDS")+1,line.indexOf("IDE"));
        validationData=line.subList(line.indexOf("VDS") + 1,line.indexOf("VDE"));
        System.out.println("testData is==="+testData);
        String testCaseName=(String)testData.get(4);
        data[k][0]=testCaseName;
        data[k][1]=testData;
        data[k][2]=validationData;
    }
}