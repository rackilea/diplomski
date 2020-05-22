... //logic
for(String obj:list)  {
    singleLineIdentiedTokens = (ArrayList<String>) sizeObject.calcCsOfStatement(obj);                       
    csMarkList.add(singleLineIdentiedTokens.size());
    allLineIdentiedTokens.add(new ArrayList<>(singleLineIdentiedTokens));// <- change this line

    System.out.println(singleLineIdentiedTokens);
    System.out.println(allLineIdentiedTokens);

    if (!(singleLineIdentiedTokens.isEmpty())) {
        singleLineIdentiedTokens.clear();
    }
}
... //more logic