List<String> list = new ArrayList<>();
list.add("app"); 
list.add("-b");
list.add("8"); 
list.add("-e"); 
list.add("u-law");
ProcessBuilder pBuilder = new ProcessBuilder(list);