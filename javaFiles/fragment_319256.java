public static void printAll(JsonNode node) {
     Iterator<String> fieldNames = node.getFieldNames();
     while(fieldNames.hasNext()){
         String fieldName = fieldNames.next();
         JsonNode fieldValue = node.get(fieldName);
         if (fieldValue.isObject()) {
            System.out.println(fieldName + " :");
            printAll(fieldValue);
         } else {
            String value = fieldValue.asText();
            System.out.println(fieldName + " : " + value);
         }
     }
}