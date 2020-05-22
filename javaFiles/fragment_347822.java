Fruit createByName(String fruitName) {
  switch (fruitName) {
    case "Orange": return new Orange();
    case ...
    default: throw new IllegalArgumentException("unknown fruit: " + fruitName);
  }
}