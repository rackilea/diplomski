List<Integer> list = Arrays.stream(scanner.nextLine().split(" "))
    .map(Integer::valueOf)
    .collect(Collectors.toList());

long firstKElements = list.size() / 4L;
long middleKelemnts = list.size() / 2L;

List<Integer> listFirstKElements = list.stream()
    .limit(firstKElements)
    .collect(Collectors.toList());
List<Integer> listMiddleKelemnts = list.stream()
    .skip(firstKElements)
    .limit(middleKelemnts)
    .collect(Collectors.toList());