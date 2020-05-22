Map<String, String> map = new HashMap<>();
map.put("fromyear", "2009");
map.put("toyear", "2010");
...

// Map that will contain the StudentDtls instances with the suffix as key
Map<String, StudentDtls> objects = new HashMap<>();
// The pattern used to extract the field name and the suffix if it exists
Pattern pattern = Pattern.compile("([a-z]+)(\\d*)");
for (Map.Entry<String, String> entry : map.entrySet()) {
    // Create the matcher
    Matcher matcher = pattern.matcher(entry.getKey());
    matcher.find();
    // Get the first group corresponding to the field name
    String fieldName = matcher.group(1);
    // Get the second group corresponding to the suffix, "" if it is not provided
    String objectId = matcher.group(2);
    // Get the current object corresponding to the suffix found
    StudentDtls object = objects.get(objectId);
    if (object == null) {
        // It has not been created so far so we create it
        object = new StudentDtls();
        objects.put(objectId, object);
    }
    // Get the field corresponding to the extracted field name
    Field field = StudentDtls.class.getDeclaredField(fieldName);
    // check if the field is accessible
    if (!field.isAccessible()) {
        // Make it accessible to be able to modify its value
        field.setAccessible(true);
    }
    // Set the value of the field for the current object
    field.set(object, entry.getValue());
}
// Print the object created
System.out.println(objects.values());