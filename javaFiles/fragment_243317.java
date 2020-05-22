int n = 2;
String s = "Hello";
String[] resultSet = IntStream.rangeClosed(1, n)
                              .mapToObj(i -> s)
                              .toArray(String[]::new);

System.out.println(Arrays.toString(resultSet));