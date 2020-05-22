public static void main(String[] args)
{
    final int it = 5;
    int pad = it;
    int i = 0;
    String space;
    while (i < it) {
        String star = new String(new char[i + 1]).replace("\0", "*\t\t");

        space = new String(new char[pad]).replace("\0", "\t");

        System.out.printf(space + star + "\n");
        ++i;

        --pad;

    }

}