String foo1 = "this_is_a_filename";
String foo2 = "this%is%not%a%filename";
String foo3 = "%+!?";

String regex = "[^a-zA-Z0-9æøåÆØÅ_ -]";

Pattern p = Pattern.compile(regex);
System.out.println("Foo1: " + p.matcher(foo1).find());
System.out.println("Foo2: " + p.matcher(foo2).find());
System.out.println("Foo3: " + p.matcher(foo3).find());