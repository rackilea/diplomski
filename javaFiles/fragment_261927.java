List<String> bla = new ArrayList();

String bla2 = bla
    .stream()
    .filter(s -> s.equals("something"))
    .findAny()
    .get();

System.out.println(bla2);