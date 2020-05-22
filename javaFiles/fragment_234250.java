public List<String> findSpringfield()
{
    List<String> results = new ArrayList<String>();
    for(int i=0; i < data2.length ; i++) {
        if(data2[i].getpostalCity().contains("SPRINGFIELD")) {
            results.add(data2[i].getzipCode().replaceAll("\"",""));  //Collects zipCodes that have Springfield in them
        }
    }
    return results;
}