List<List<String>> ls2d = new ArrayList<List<String>>();
List<String> x = new ArrayList<String>();
x.add("Hello");
x.add("world!");
ls2d.add(x);

System.out.println(Arrays.deepToString(ls2d.toArray()));