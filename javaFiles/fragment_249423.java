JSONParser parser = new JSONParser();

JSONObject parents = (JSONObject) parser.parse(new FileReader("filename"));

JSONObject parent1 = (JSONObject) parents.get("PARENT1");
JSONObject parent2 = (JSONObject) parents.get("PARENT2");
JSONObject parent3 = (JSONObject) parents.get("PARENT3");

System.out.println("Parent 1");
System.out.println("\tChild 1: " + parent1.get("child_attr1"));
System.out.println("\tChild 2: " + parent1.get("child_attr2"));

System.out.println("Parent 2");
System.out.println("\tChild 1: " + parent2.get("child_attr1"));
System.out.println("\tChild 2: " + parent2.get("child_attr2"));

System.out.println("Parent 3");
System.out.println("\tChild 1: " + parent3.get("child_attr1"));
System.out.println("\tChild 2: " + parent3.get("child_attr2"));