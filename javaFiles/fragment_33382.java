String a = "cat dog monkey";
String b = "cat cow monkey";
String c = "cat dog duck";

Set<String> aSet = new HashSet<>(Arrays.asList(a.split(" ")));
Set<String> bSet = new HashSet<>(Arrays.asList(a.split(" ")));
Set<String> cSet = new HashSet<>(Arrays.asList(a.split(" ")));

Set<String> result = new HashSet<>(aSet);
result.retainAll(bSet);
result.retainAll(cSet);