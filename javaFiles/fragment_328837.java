void convert(String str)
{
    try {
        int i = Integer.parseInt(str);
        System.out.println (i);
    } catch (NumberFormatException e) {
        System.out.println ("Should start with fixnumber");
    }
}