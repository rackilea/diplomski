Map<Character, String> mapping = new HashMap<>();
mapping.put('a', "one");
mapping.put('e', "two");
mapping.put('i', "three");
mapping.put('o', "four");
mapping.put('u', "five");

String res = "Hello How are u!".chars()
        .mapToObj(ch -> mapping.getOrDefault((char) ch, 
                                  Character.toString((char) ch)))
        .collect(Collectors.joining());

System.out.println(res);