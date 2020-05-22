String html = "<p>Ben & Jerry is <a href=\"http://www.domain.com?a=1&b=2&amp;c"
            + "=3\">cool</a></p>\n<p>Ben & Jerry is <a href=\"/index.htm?a=1&b"
            + "=2&amp;c=3\">cool</a></p>";
String pattern = "(?i)" + // case insensitive modifier
            "(" + // open the capturing group 1
                "(?:" + // open a non capturing group
                    "<a\\s[^>]*?\\bhref\\s*=\\s*[\"']?" + // content until the href attribute value
                  "|" + // OR
                    "\\G(?<!^)" + // contiguous to a precedent match
                ")" + // close the non capturing group
                "[^\\s\"'&>]++" + // value content that is not a &
            ")" + // close the capturing group 1
            "&(?:amp;)?"; // & with optional "amp;"
String res = html.replaceAll(pattern, "$1**");
System.out.println(res);