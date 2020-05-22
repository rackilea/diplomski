...
} else {
  inputString.toLowerCase().chars()
      .mapToObj(c -> vowelsList.contains((char) c) ? " VOWEL " : " consonant ")
      .forEach(System.out::print);
}
...