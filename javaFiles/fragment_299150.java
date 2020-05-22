public static void main(String[] args) {
    String html = "<b><b>hello</b></b>\r\n" + "<b><i>hello</i></b>\r\n"
            + "<b><b><i><b>hello</b></i></b></b>\r\n"
            + "<b><u><b><i><u><i>hello</i></u></i></b></u></b>";

    Document doc = Jsoup.parseBodyFragment(html);

    System.out.println("before: ");
    System.out.println(doc.body());

    for (Element el : doc.getAllElements()) {
        if (hasSameTypeAncestor(el)) {
            el.unwrap();
        }
    }

    System.out.println("========");
    System.out.println("after:");
    System.out.println(doc.body());

}

private static Set<String> tagsIDontWantToNest = new HashSet<>(Arrays.asList("b","i","u"));

private static boolean hasSameTypeAncestor(Element element) {

    Tag tag = element.tag();
    //handle only these tags: <b> <i> <u>
    if (tagsIDontWantToNest.contains(tag.getName())) {
        for (Element el : element.parents()) {
            if (el.tag().equals(tag)) {
                return true;
            }
        }
    }
    return false;
}