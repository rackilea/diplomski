List<String> list = new ArrayList<String>();

list.add("11");
list.add("22");
list.add("33");

String joined = String.join(",", list);

System.out.println(joined);
//prints "11,22,33"