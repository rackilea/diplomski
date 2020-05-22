Date now = new Date());
long nowMillis = now.getTime();
long oneHourInMills = 3600000;
Date anHourAgo = new Date(nowMillis - oneHourInMillis);
ParseQuery<ParseObject> query = ParseQuery.getQuery("AlertsClass");
query.orderByDescending("createdAt");
query.whereGreaterThanOrEqualTo("createdAt", anHourAgo);