Map<String, Map<String, Integer>> one_index = new HashMap<String, Map<String, Integer>>();

Map<String, Integer> term_index = new HashMap<String, Integer>();
term_index.put("B", 1);
term_index.put("C", 1);
term_index.put("D", 1);
term_index.put("E", 1);
one_index.put("A", term_index);

term_index = new HashMap<String, Integer>();
term_index.put("A", 1);
term_index.put("C", 0);
term_index.put("D", 1);
term_index.put("E", 1);
one_index.put("B", term_index);