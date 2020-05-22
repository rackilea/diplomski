public static Person parseCommaDelim(String s) {
    String[] tokens = s.split(",");

    String person = tokens[0];
    int age = Integer.parseInt(tokens[1];
    String city = tokens[2];
    int sibCount = Integer.parseInt(tokens[3]);

    return new Person(person, age, city, sibCount);
  }