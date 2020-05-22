String text = new Scanner(new FileReader("1.txt")).useDelimiter("\\A").next();
    String[] sp = text.split("/");
    List<Integer>  listIntegers = Stream.of(sp)
                                        .map( s -> Integer.valueOf(s))
                                        .collect(Collectors.toList());
    listIntegers.forEach(i -> System.out.print(" " + i));