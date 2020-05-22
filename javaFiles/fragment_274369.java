public static void main(String[] args) {
    String rawData = "946352705  U.S.A.  UNIMOX DRUGS PVT. LTD.  \"65 West Alisal St, salinas, CA 93901\" \n946357899  U.S.A.  NIL DRUGS PVT. LTD.  \"86 East Alisal St, salinas, CA 93905\"";
    String[] lines = rawData.trim().split("\n");
    StringBuilder htmlData = new StringBuilder("<doctypehtml1><html><body>");
    for (String line : lines) {
        String[] words = line.trim().split("  ");
        htmlData.append("<code>" + words[0].trim() + "</code>");
        htmlData.append("<i>" + words[1].trim() + "</i>");
        htmlData.append("<B>" + words[2].trim() + "</B>");
        htmlData.append("<p>" + words[3].trim() + "</p>");
    }
    htmlData.append("</body></html>");
    System.out.println(htmlData.toString());
}