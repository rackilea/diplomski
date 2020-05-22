for (Element link : document.select("a")) {
    String relHref = link.attr("href");
    String absHref = link.attr("abs:href");
    System.out.println(relHref);
    System.out.println(absHref);
}