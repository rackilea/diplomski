public static void repeatLetters()
{
    String text = "dean";
    int n = 3;
    StringBuilder repeat = new StringBuilder();
    for (int i = 0; i < text.length(); i++) {
        for (int j = 0; j < n; j++) {
            repeat.append(text.charAt(i));
        }
    }
    System.out.println(repeat);
}