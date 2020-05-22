String str = new Scanner(System.in).nextLine();
int size = 2;
List<String> res = IntStream.range(0, str.length() - size + 1)
                            .mapToObj(i -> str.substring(i, i + size))
                            .collect(Collectors.toList());
System.out.println(res); // [he, el, ll, lo]