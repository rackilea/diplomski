String st = "citations?view_op\\x3dsearch_authors\\x26hl\\x3dpl\\x26oe\\x3dLatin2\\x26mauthors\\x3dAGH+University+of+Science+and+Technology\\x26after_author\\x3dslQKAC78__8J\\x26astart\\x3d10";
System.out.println("Before Decoding: " + st);
Pattern p = Pattern.compile("\\\\x([0-9A-Fa-f]{2})");
Matcher m = p.matcher(st);
while ( m.find() ){
    String c = Character.toString((char)Integer.parseInt(m.group(1), 16));
    st = st.replaceAll("\\" + m.group(0), c);
    m = p.matcher("After Decoding: " + st);//optional, but added for clarity as st has changed
}
System.out.println(st);