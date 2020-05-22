String data = "temp/*.jpg, usr/*.pdf, var/lib/*.so, tmp/*, usr/*, usr/*.*";

Pattern p = Pattern
        .compile("(?<path>(\\w+/)+)((?<name>\\w+|[*]))?([.](?<extension>\\w+|[*]))?");

Matcher m = p.matcher(data);
while (m.find()) {
    System.out.println("data=" + m.group());
    System.out.println("path=" + m.group("path"));
    System.out.println("name=" + m.group("name"));
    System.out.println("extension=" + m.group("extension"));
    System.out.println("------------");
}