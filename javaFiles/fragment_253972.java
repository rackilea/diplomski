private static final Pattern emailRegex = Pattern.compile("([^,]+?)@([^,]+)");
public static void main(String[] args) {
  final String emails = "kid@gmail.com, stray@yahoo.com, miks@tijuana.com";
  System.out.println("User has e-mail accounts on these domains: " +
      matcherStream(emailRegex.matcher(emails))
      .map(gs->gs[2])
      .collect(joining(", ")));
}