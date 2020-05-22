String html = "FOO<span style='font-family:Verdana;mso-bidi-font-family:"
        + "\"Times New Roman\";display:none;mso-hide:all'>contents</span>BAR";
    // regex matches every opening tag that contains 'mso-' in an attribute name
    // or value, the contents and the corresponding closing tag
    String regex = "<(\\S+)[^>]+?mso-[^>]*>.*?</\\1>";
    String replacement = "";
    System.out.println(html.replaceAll(regex, replacement)); // prints FOOBAR