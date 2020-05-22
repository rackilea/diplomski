public static void main(String[] arg) throws FileNotFoundException
{

    Scanner scan = null;
    scan = new Scanner(new File("Input.txt"));
    int count = 0;

    Set<String> set = new LinkedHashSet<String>();

    while(scan.hasNext())
    {
        String word = scan.next().replaceAll("[\\W]", "").toLowerCase();
        set.add(word);
        count++;
    }
    scan.close();
    // System.out.println(set);
    System.out.println();
    System.out.println("Input.txt  has " + count + " words.");

    // How do I print a set by myself?
    for (String word : set) {
        // Also remove commas
        System.out.println(word.replaceAll(",",""));
    }

}