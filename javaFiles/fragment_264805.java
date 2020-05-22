JAXBContext jb=JAXBContext.newInstance("generated");

Unmarshaller unmarshaller=jb.createUnmarshaller();
NewDataSet newDataSet=(NewDataSet)unmarshaller.unmarshal(xsr);
for(Table t: newDataSet.getTable()){
    System.out.println(t.getTITLE());
}