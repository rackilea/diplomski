String firstAlphabetically = names[0];
for (String name : names) {
  if (name.compareTo(firstAlphabetically) < 0) {
    firstAlphabetically = name;
  }
}