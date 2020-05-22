// Build dynamic query

StringBuilder whereClause = new StringBuilder();
Iterator<PageID> it = yourMap.keySet().iterator();
while(it.hasNext()){
  PageID key = it.next();
  Set<SubscriberIDS> value = yourMap.get(key);

  // You need to fill the 'IN' clause with multiple parameters, one for each subscriber id
  StringBuilder inClause = new StringBuilder();
  for(SubscriberIDS subId : value){
    if(inClause.length > 0){
      inClause.append(", ");
    }
    inClause.append("?");

    preparedStatement.setInt(paramIndex++, subId.getId());
  }

  // For each page id we append a new 'OR' to our query
  if(whereClause.lenght > 0){
    whereClause.append(" OR ");
  }
  whereClause.append("(PAGEID=? AND SUBSCRIBERID IN (").append(inClause.toString()).append("))");
}

String query = "SELECT PAGEID, COUNT(SUBSCRIBERID) AS SUBSCRIBERS FROM FB_SUBSCRIPTIONS WHERE " + whereClause.toString() + " GROUP BY PAGEID";

// Create prepared statement and set parameters

PreparedStatement preparedStatement = connection.prepareStatement(query);
int paramIndex = 0;
it = yourMap.keySet().iterator();
while(it.hasNext()){
  PageID key = it.next();
  Set<SubscriberIDS> value = yourMap.get(key);

  preparedStatement.setInt(paramIndex++, key.getId());

  for(SubscriberIDS subId : value){
    preparedStatement.setInt(paramIndex++, subId.getId());
  }
}

// Execute query, loop over result and calculate new subscriptions

ResultSet rs = preparedStatement.executeQuery();

while(rs.next()){
  int pageId = rs.getInt("PAGEID");
  int newSubscriptions = yourMap.get(pageId).size() - rs.getInt("SUBSCRIBERS");
  System.out.println(pageId + ", " + newSubscriptions);
}