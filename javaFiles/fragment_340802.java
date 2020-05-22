String originalString = "hello";
// Use a StringBuilder to save all the characters
StringBuilder builder = new StringBuilder();

for (char c : originalString.toCharArray()) {
  // Add 1 to each character and append it
  builder.append((char) (c + 1));
}

// Now the builder contains the String with the shifted values
System.out.println(builder);