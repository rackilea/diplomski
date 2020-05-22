private static List<String> generate30DayFileGlobs(DateTime now) {
  // ..
}

public static void main() {
  Pipeline p = // ..

  p.apply(Create.<String>of(generate30DayFileGlobs(DateTime.now())));
   .apply(TextIO.readAll());

  // ..
}