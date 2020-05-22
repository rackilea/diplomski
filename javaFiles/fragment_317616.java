//Edit your min and max, e.g. Integer.MAX_VALUE and Integer.MIN_VALUE
int min = 0;
int max = 10;

for(int i = min; i < max; i++){
    //Make 16 bit long binary Strings
    String s = String.format("%16s", Integer.toBinaryString(i)).replace(' ', '0');

    //Make 4 bits long chunks
    List<String> chunks = new ArrayList<>();
    Matcher matcher = Pattern.compile(".{0,4}").matcher(s);
    while (matcher.find()) {
        chunks.add(s.substring(matcher.start(), matcher.end()));
    }

    StringBuilder b = new StringBuilder();
    for (String c : chunks) {
        //Here you can count the 1 and 0 of the current chunk with c.charAt(index)
        b.append(c);
        b.append(" ");
    }
    System.out.println(b.toString());
}