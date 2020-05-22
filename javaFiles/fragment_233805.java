public static void main(String[] args) throws IOException {
    List<String> list = Arrays.asList("my  {test} value", "my  {   test     } value", "my  { test  } value",
            "my  { test hello I am  } value", "my  { testing 10 times  } value");
    Pattern p = Pattern.compile("\\{\\s*(.*?)\\s*\\}");

    list.forEach(x -> {
        Matcher m = p.matcher(x);
        if (m.find()) {
            System.out.println(x + " --> " + m.group(1));
        }
    });
}