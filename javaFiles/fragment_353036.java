// this must hold!
// combiner.apply(u, accumulator.apply(identity, t)) == accumulator.apply(u, t)

Integer identity = 0;
String t = "aa";
Integer u = 3; // "bbb"
BiFunction<Integer, String, Integer> accumulator = (Integer i, String s) -> i + s.length();
BinaryOperator<Integer> combiner = (left, right) -> left + right + left;

int first = accumulator.apply(identity, t); // 2
int second = combiner.apply(u, first); // 3 + 2 + 3 = 8

Integer shouldBe8 = accumulator.apply(u, t);

System.out.println(shouldBe8 == second); // false