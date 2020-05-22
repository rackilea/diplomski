String field = "vendorNames.vendorName";
String token = "rooster";
int editDistance = getEditDistance(token); //returns 1 for "rooster"
int prefixLength = getPrefixLength(token); //returns 1 for "rooster"

QueryDescriptor queryDescriptor = ElasticsearchQueries.fromJson(
"{"
  + "\"query\": {"
    + "\"bool\": {"
      + "\"must\": {"
        + "\"match\": {"
          + "\"" + field + "\": {"
            + "\"query\": \"" + token + "\","
            + "\"fuzziness\": " + editDistance + ","
            + "\"prefix_length\": " + prefixLength
          + "}"
        + "}"
      + "}"
    + "}"
  + "}"
+ "}"
);

List<?> result = session.createFullTextQuery( queryDescriptor, MyEntity.class )
                .list();