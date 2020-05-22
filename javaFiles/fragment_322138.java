private static String input = "5|12345|value1|value2|value3|value4+5|777|value1|value2|value3|value4?5|777|value1|value2|value3|value4+";

private void split(List<String> input, List<String> output, String split) {
    for (String s: input) {
          if (s.contains(split))
          {
             output.addAll(Arrays.asList(s.split(Pattern.quote(split)));
          }
          else
              output.add(s);
    }
}