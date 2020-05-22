ArrayList<String> var = new ArrayList<>();
var.add("0010101000");
var.add("0010101010");

ArrayList<Integer> var1 = new ArrayList<>();

String var2 = var.get(0).substring(0,1);
int var3 = Integer.parseInt(var2);
System.out.println(var3);