String str = "[bla bla,bla2 bla2]";

Pattern p = Pattern.compile("([^\\[][^\$,]*)");
Matcher m = p.matcher(str);
if(m.find()) {
    System.out.println( m.group(1));
}