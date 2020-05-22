public static void main(String[] args)
{
    String[] validPair = {"[BOLD]", "[/BOLD]" };
    String toCheck = "Example [BOLD]bold long text[/BOLD] other example [BOLD]bold short[/BOLD]";
    OwnIterator itr = new OwnIterator(toCheck, validPair);
    while (itr.hasNext()) {
        System.out.println(itr.next());
    }
}