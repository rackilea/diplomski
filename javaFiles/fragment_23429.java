ImmutableMap<String, File> mapOfFileNames = Maps.uniqueIndex(...);
/*
 * The entry containing the file that was at index 5 in the original list
 * and its filename.
 */
Map.Entry<String, File> entry = mapOfFileNames.entrySet().asList().get(5);