public static void main(String[] args)
{
    String array = "uuuuuuuupppppppssssssssss";
    System.out.println(array);

    while ( array.contains("p") )
    {
        array = array.replaceFirst("p", "P");
        System.out.println(array);
    }
}