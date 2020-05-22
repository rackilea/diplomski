Configuration conf = Configuration.builder().options(Option.AS_PATH_LIST).build();
List<String> pathList = JsonPath.using(conf).parse(payload).read("$..ppsNo");

/* Returns :
 * [
 *   "$['contractor']['ppsNo']",
 *   "$['fullTimeStaff']['ppsNo']"
 * ]
 */