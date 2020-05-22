String bookRef = "Schulz V, Hansel R, Tyler VE. Rational phytotherapy: a physician's guide to herbal "
        + "medicine. 3rd ed., fully rev. and expand. Berlin: Springer; c1998. 306 p.";

File file = new File("D:/dev/xml-part.txt");
final String TAB = "    ";
try (PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8")))) {
    out.println(TAB + "<element-citation publication-type=\"book\" publication-format=\"print\">");

    String[] lines = bookRef.split("\\.\\s*");

    String names = lines[0];
    String[] nameArray = names.split(",\\s*");
    for (String name : nameArray) {
        String[] nameParts = name.split(" +", 2);
        out.println(TAB + TAB + "<name>");
        out.println(TAB + TAB + TAB + "<surname>" + nameParts[0] + "</surname>");
        out.println(TAB + TAB + TAB + "<given-name>" + nameParts[1] + "</given-name>");
        out.println(TAB + TAB + "</name>");
    }
    out.println(TAB + TAB + "<source>" + lines[1] + "</source>");
    ...

    out.println(TAB + "</element-citation>");
} catch (FileNotFoundException | UnsupportedEncodingException ex) {
    Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
}