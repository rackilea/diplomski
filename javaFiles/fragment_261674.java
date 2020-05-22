LocalTime start = LocalTime.now();
String s = "Foo;";
for(int i = 0; i < 50_000; i++){
    s += "Row" + i + ";\n";
}
System.out.println(Duration.between(start, LocalTime.now()).toMillis());
System.out.println(s.substring(0, 50));