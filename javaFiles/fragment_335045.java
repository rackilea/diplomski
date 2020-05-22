public static void main(String[] args) {
    String input = new Scanner(System.in).nextLine();

    int[] counts = countLetters(input);

    IntStream.range(0, counts.length)
            .filter(i -> counts[i] > 0)
            .forEachOrdered(i -> System.out.printf("%c appears %s %s%n", 
                    'a' + i, 
                    counts[i], 
                    counts[i] > 1 ? "times" : "time"
            ));
}

public static int[] countLetters(String s) {
    return s.chars() // this is better than stream(split(""))
            .filter(Character::isLetter)  // WRONG to assume that all letters are [a-zA-Z]
            .map(chr -> Character.toLowerCase(chr) - 'a')
            .collect(
                    () -> new int[26], 
                    (ary, i) -> ary[i]++, 
                    (a,b) -> Arrays.setAll(a, i -> a[i] + b[i])
            );
}