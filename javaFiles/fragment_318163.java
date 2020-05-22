Query mainQuery, filterQuery;

BooleanQuery query = new BooleanQuery();

// add the main query for scoring
query.add(mainQuery, Occur.SHOULD);

// prevent the filter query to participate in the scoring
filter.setBoost(0);
// make the filter query required
query.add(filterQuery, Occur.MUST);