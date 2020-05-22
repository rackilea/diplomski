public static void main (String[] args) throws Exception
{
    Random rnd = new Random();
    int randomNumber = rnd.nextInt(100);

    char[] chr = new char[100];
    Arrays.fill(chr,'-');
    chr[randomNumber] = '0';

    System.out.print(new String(chr));
}