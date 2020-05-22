BooleanJunction namesBool = qb.bool();
String field = "vendorNames.vendorName";
String token = "rooster";
int editDistance = getEditDistance(token); //returns 1 for "rooster"
int prefixLength = getPrefixLength(token); //returns 1 for "rooster"

namesBool.must(
    new FuzzyQuery(new Term(field, token), editDistance, prefixLength)
);