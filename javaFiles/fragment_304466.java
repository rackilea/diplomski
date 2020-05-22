public class RemoveDuplicates
{
    public static void main(String... args)
    {
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("apple");
        list.add("pear");
        list.add("pear");
        list.add("pear");
        list.add("peach");

        System.out.println("Original list: ");
        for (String s : list)
            System.out.println(s);

        String temp = "";
        for (Iterator<String> iterator = list.iterator(); iterator.hasNext();)
        {
            String s1 = iterator.next();
            if (temp.equals(s1))
            {
                iterator.remove();
            }
            temp = s1;
        }

        System.out.println("\nProcessed list:");
        for (String s : list)
            System.out.println(s);
    }
}