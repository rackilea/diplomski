String[] input = {
  "1ST MTG-HAZ @230 MAPLE WAY STREET FLOWERS, WY 23042",
  "230 MAPLE WAY STREET FLOWERS, WY 23042"
};
for (String s: input) {
    //                               | start of input
    //                               || 0 or more characters, reluctantly quantified
    //                               ||   | followed by 2 digits (non-capturing)
    //                               ||   |            | replace with empty
    System.out.println(s.replaceAll("^.*?(?=\\d{2,})", ""));
}