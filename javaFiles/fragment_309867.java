if (line.matches(s_mapping)){
    Matcher matcher = mapName.matcher(line);
    System.out.println(line);
    System.out.println(matcher);
    matcher.find();
    o_mapping = matcher.group(1);
    System.out.println(o_mapping);