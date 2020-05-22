Random r = new Random(digest);

String str = "";

while (str.length < 5) {
    int i = r.nextInt(128);

    if (i > (int)'a' && i < (int)'z')
        str += (char)i;
}