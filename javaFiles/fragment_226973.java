public static void main(String[] args) {
  String descriptionEscaped = "Domnul Florin C&icirc;ţu afirmă";
    descriptionEscaped = 
  StringEscapeUtils.unescapeHtml4(descriptionEscaped);
    System.out.println(descriptionEscaped);
}