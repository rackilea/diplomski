BufferedReader br = new BufferedReader(new FileReader(fileName));
List<String> list = br.lines()
                      .map(e -> e.split("\\s+"))
                      .flatMap(lineArr -> Arrays.stream(lineArr))
                      .collect(Collectors.toList());
Collections.reverse(list);