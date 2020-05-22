List<String> letters = Arrays.asList("A", "B", "C");
List<Integer> numbers = Arrays.asList(1, 2, 3);

List<Pair<String, Integer>> board = letters.stream()
                .flatMap(crossWith(numbers::stream, Pair::new))
                .collect(toList());


List<String> ops = Arrays.asList("+", "-", "*", "/");

List<String> combinations = letters.stream()
                .flatMap(crossWith(ops::stream, String::concat))
                .flatMap(crossWith(letters::stream, String::concat))
                .collect(toList());   // triple cartesian product