Map<String, List<String>> mainCategories = new TreeMap<>();
mainCategories.put("A", Arrays.asList("A1", "A2", "A3"));
mainCategories.put("B", Arrays.asList("B1", "B2"));
mainCategories.put("C", Arrays.asList("C1"));

System.out.println(mainCategories);
System.out.println(mainCategories.get("B"));