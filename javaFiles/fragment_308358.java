// String
Example<String> strTypedExample = Example.newTypedExample(String.class);

strTypedExample.setData("String Data");
System.out.println(strTypedExample.getData()); // String Data

// Integer
Example<Integer> intTypedExample = Example.newTypedExample(Integer.class);

intTypedExample.setData(123);
System.out.println(intTypedExample.getData()); // 123