//I'm using Google Guava's classes here
SetMultimap<String, Coll_Daily_Main> dailies = ...;//use one that fits your needs

//Iterate over n daily entries and put them into the map which should be O(n)
dailyList.forEach( cdm -> dailies.put( cdm.getAccountId().trim(), cdm ) );

//Iterate over the (smaller) set of monthly entries and do a lookup for the dailies which should be O(m)
for(Coll_Monthly_Main monthlyAccount : monthlyList) {
  Set<Coll_Daily_Main> dailiesForAccount = dailies.get( monthlyAccount.getAccountId().trim() );

  //level done, either go down to the next or try to further straighten it out or optimize
}