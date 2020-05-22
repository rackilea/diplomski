Map<Integer, List<Integer>> numbers = new HashMap<Integer, List<Integer>>();
numbers.put(64, Arrays.asList(61, 68, 77));
numbers.put(65, Arrays.asList(63, 66, 66, 70));
numbers.put(66, Arrays.asList(69, 75, 2));
numbers.put(67, Arrays.asList(65, 77));
numbers.put(2, Arrays.asList(4));
numbers.put(4, Arrays.asList(2));

List<Integer> topValues = numbers.entrySet().stream()
       .collect(
               Collectors.toMap(
                    Map.Entry::getKey,
                    entry -> entry.getValue().size()
                ) // get a map where key=original key and value list size
       )  // {64=3, 65=4, 2=1, 66=3, 67=2, 4=1}
       .entrySet()
       .stream() // sort map by value - list size
       .sorted( Map.Entry.<Integer,Integer>comparingByValue().reversed())
       .limit(3) // get top 3 
       .map(Map.Entry::getKey)
       .collect(Collectors.toList());

System.out.println(topValues); // [65, 64, 66]