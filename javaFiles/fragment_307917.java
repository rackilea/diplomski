public class Main {
  public static void main(final String[] args) {

    // case 1:
    // String s = "-1 tvg-name=\"Test Channel\"
    // tvg-logo=\"http://awebsite/logos/TestChannel.png\"";
    // case 2:
    String s =
            "-1 tvg-name=\"Test Channel\" tvg-logo=\"http://awebsite/logos/TestChannel.png\" group-title=\"Movies\"";
    // case 3:
    // String s =
    // "-1 tvg-logo=\"http://awebsite/logos/TestChannel.png\" tvg-name=\"Test
    // Channel\" group-title=\"Movies\"";

    String tvgLogo = "tvg-logo=\"";
    int tvgLogoIndex = s.indexOf(tvgLogo) + tvgLogo.length();
    String icon = s.substring(tvgLogoIndex, s.indexOf('"', tvgLogoIndex)).replace("=", "")
            .replace("\"", "").replace("\n", "");

    System.out.println("Logo:" + icon);
  }
}