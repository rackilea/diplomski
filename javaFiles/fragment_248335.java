RegExp p = RegExp.compile("\\[{2}((?:.)*?)\\]{2}", "g");
MatchResult m;
StringBuffer sb = new StringBuffer();
int beginIndex = 0;
while ((m = p.exec(content.asString())) != null) {
    String one = m.getGroup(1);
    int endIndex = m.getIndex();

    sb.append(content.asString().substring(beginIndex, endIndex));

    sb.append("<a href=\"#!p:" + URL.encode(one) + "\">" + one + "</a>");

    beginIndex = p.getLastIndex();
}

sb.append(content.asString().substring(beginIndex));