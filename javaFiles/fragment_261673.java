LocalTime start = LocalTime.now();
StringBuilder sb = new StringBuilder("Foo;");
for(int i = 0; i < 50_000; i++){
    sb.append("Row").append(i).append(";\n");
}
System.out.println(Duration.between(start, LocalTime.now()).toNanos());
String s = sb.toString();
System.out.println(s.substring(0, 50));