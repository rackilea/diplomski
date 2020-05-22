POJO vPOJO = new POJO();
final POJO.abc in = vPOJO.new abc(); //Notice the final
System.out.println(in.name);
in.name = "World";
System.out.println(in.name);
in = vPOJO.new abc(); // Compilation error
System.out.println(in.name);