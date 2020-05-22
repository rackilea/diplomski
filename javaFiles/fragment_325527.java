//somewhere else defined
private static final int MAX_SIZE_OF_SOME_LIST = 10; //instead of j=10, you simply have to know what the number 10 represents!

List<SomeObject> resultList = new ArrayList<someObject>();
List<SomeObject> returnList = bunruiSummaryService.getFromDB(param); //at this point, make sure to return an empty list instead of null
int maxSize = MAX_SIZE_OF_SOME_LIST;
if(returnList.size() < MAX_SIZE_OF_SOME_LIST){
    maxSize = returnList.size(); //if you ensured the returned list is not null, if the returned list is empty, you get 0 here
}
//even so
int maxSize = returnList.size() < MAX_SIZE_OF_SOME_LIST ? returnList.size() : MAX_SIZE_OF_SOME_LIST;

for(int i = 0; i<maxSize; i++){
    resultList.add(returnList.get(i));
}

//or you could use subList:
resultList.addAll(returnList.subList(0, maxSize));