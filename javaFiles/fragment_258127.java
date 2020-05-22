public static void main(String[] args)
{

    int n = 6;
    int i = 0;
    int pad = 7;
    while (i < n) 
    {

        String star = new String(new char[1 + i *2]).replace("\0", "*\t");
        String space = new String(new char[1 + pad]).replace("\0", "\t");
        System.out.printf(space + star + "\n");
        ++i;
        --pad;
    }

}