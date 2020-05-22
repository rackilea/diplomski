try (BufferedReader br = new BufferedReader(...)) {
    String[] headers = br.readLine().split(",");
    List<Map<String, String>> records = 
            br.lines().map(s -> s.split(","))
                      .map(t -> IntStream.range(0, t.length)
                                         .boxed()
                                         .collect(toMap(i -> headers[i], i -> t[i])))
                      .collect(toList());
    System.out.println(headers);
    System.out.println(records);
};