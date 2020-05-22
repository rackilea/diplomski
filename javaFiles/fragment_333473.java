String jsonInput = "{\"1222\": [\"Joe\", 26, 158],\"1232\": [\"root\", 29, 168], \"emp_count\" : \"2\"}";
JsonNode node = mapper.readTree(jsonInput);
if (node.has("emp_count")) {
   int employeesInArray = ((ObjectNode) node).remove("emp_count").asInt();
   System.out.println("Num of employees in array: " + employeesInArray);
} else {
   System.out.println("Num of employees was not provided, missing emp_count element");
}

//updated JSON input String, that works as before
jsonInput = node.toString();