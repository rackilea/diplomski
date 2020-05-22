String s = "00 44 88 45 00 25 78 46 00 46 58 00";
List<String> result = Arrays.stream(s.split("\\s+"))
       .filter(i -> !i.equals("00"))
       .collect(Collectors.toList());
System.out.println(result.get(0));                // => 44
System.out.println(result.get(result.size()-1));  // => 58