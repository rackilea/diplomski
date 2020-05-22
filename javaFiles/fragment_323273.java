String result = subject.replaceAll(
    "(?xi)(      # Match and capture in group 1:\n" +
    "REF\\(      # REF(\n" +
    "\\[\\d+\\], # a number in brackets, comma,\n" +
    "\\[\\d+\\]  # a number in brackets\n" +
    ")           # End of capturing group\n" +
    ",\\[\\d+\\] # Match a comma and a third number in brackets", "$1");