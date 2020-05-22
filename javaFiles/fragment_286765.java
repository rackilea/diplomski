public static void main(final String... args)
{
    final Pattern p1 = Pattern.compile("^dog$");
    final Pattern p2 = Pattern.compile("^dog$", Pattern.MULTILINE);

    final String input = "cat\ndog\nTasmanian devil";

    System.out.println(p1.matcher(input).find());
    System.out.println(p2.matcher(input).find());
}