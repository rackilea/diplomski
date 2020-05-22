System.out.println(Stream.of("abc", "def", "ghi")
    .map(a -> {
       if (a.equals("def"))
          return "xyz";
       else
          return a;
    })
    .collect(Collectors.toList()));