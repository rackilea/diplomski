// test response
String response = "[3451605#John#600#Doe],[3503101#Jane#100#Doe]";
// itemizing "objects"
String[] items = response.split(",");
// iterating "objects"
for (String item: items) {
    // cleaning square brackets and splitting by "#"
    String[] properties = item.replaceAll("\\[|\\]", "").split("#");
    // printing each object's properties
    System.out.println(Arrays.toString(properties));
}