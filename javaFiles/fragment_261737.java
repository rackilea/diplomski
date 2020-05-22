public static void main(String[] args)
{
    // the example string
    final String curString = "aple";

    // get the starting character, which is the end of the string
    // in the example, will be 'e'
    final char startChar = curString.charAt(curString.length() - 1);

    // construct our compilation; this could also be List<Character>
    //  which would make somethings easier, but would have to assemble
    //  at the end
    StringBuilder sb = new StringBuilder();
    sb.append(curString);

    // we want the character after the one on the end of the string to start
    char c = nextChar(startChar);        

    // we want 26 total entries
    while (sb.length() < 26) {

        // we cannot append a character that already exists, so spin
        // until we find one not in the compilation
        while (hasChar(sb, c)) {
            c = nextChar(c);
        }

        // we now have the one we want, so append it
        sb.append(c);

        // we know we need at least the next character after the one we
        //  just appended, so get it and loop; loop will terminate if
        //  we've added enough
        c = nextChar(c);
    }


    // display the result
    System.out.printf("Final String %28s has length of %3d", sb.toString(), 
            sb.length());
}


private static boolean hasChar(StringBuilder sb, char c)
{
    for (int i = 0; i < sb.length(); ++i) {
        if (sb.charAt(i) == c) {
            return true;
        }
    }

    return false;
}

private static char nextChar(int idx)
{
    ++idx;
    if (idx > 'z') {
        idx = 'a';
    }

    return (char)idx;
}