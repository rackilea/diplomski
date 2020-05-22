Character[] chars = { 'H', 'e', 'l', 'l', 'o' };

String s = Arrays.stream(chars)
                 .map(Object::toString)
                 .collect(Collectors.joining());

System.out.println(s);