private Map<String, Set<String>> userBusiness = new HashMap<>();

...

String[] fields = output.split("\t");
userBusiness.put(fields[0], new HashSet<>(Collections.singletonList(fields[1])));