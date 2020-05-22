public static void main(String[] args) {
    String[] cat = {"car", "schema cat", "schemacat", "schemac"};
    String[] dog = {"dog", "schema dog", "schemadog", "schemad"};
    String[] horse = {"horse", "schema horse", "schemachorse", "schemah"};
    String value = "schema cat";
    System.out.println(Arrays.toString(whichArrayContains(value, cat, dog, horse)));   // cat
    System.out.println(Arrays.toString(whichArrayContains(value, dog, horse)));        //null
}