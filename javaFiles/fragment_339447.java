int[] a = {121, 144, 19, 161, 19, 144, 19, 11};
int[] b = {121, 14641, 20736, 361, 25921, 361, 20736, 361};

// Make a list containing the squares out of the b array
List<Integer> squares = Arrays.stream(b)
    .boxed()
    .collect(Collectors.toList());

// square all the values in B,
// and check that all the resultant values are present in the squares list
boolean same = Arrays.stream(a) // Stream<Integer> containing values in array a
    .map(i -> i* i) // Stream<Integer> containing values in array a squared
    .allMatch(squares::contains); // reduce to a boolean insuring that all values in the Stream<Integer> are present in the squares list

System.out.println(same);