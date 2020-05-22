public static void repeatLetters()
{
    String text = "dean", replace = "";
    int n = 3;
    for (int i = 0; i < n; i++) replace += "$1";
    System.out.println(text.replaceAll("(.)", replace));
}