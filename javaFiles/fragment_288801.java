// From user input
String usernamePrefix = "XX";

Filter usernameGreaterThanPrefixFilter =
  new FilterPredicate("username",
                      FilterOperator.GREATER_THAN_OR_EQUAL,
                      usernamePrefix);

Filter usernameLessThanLargestPossibleFilter =
  new FilterPredicate("username",
                      FilterOperator.LESS_THAN,
                      usernamePrefix + "\ufffd");

Filter usernameKindaLikeFilter =
  CompositeFilterOperator.and(usernameGreaterThanPrefixFilter, usernameLessThanLargestPossibleFilter);

Query q = new Query("User").setFilter(usernameKindaLikeFilter);