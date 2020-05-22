abstract class AbstractCard
{
    int priority;
    private static Set<Integer> usedPriorities = new LinkedHashSet<Integer>();
    private static Random random = new Random(0);

    protected AbstractCard(int lowPriority, int highPriority)
    {
        Set<Integer> availablePriorities = new LinkedHashSet<Integer>();
        for (int i = lowPriority; i <= highPriority; i++)
        {
            availablePriorities.add(i);
        }
        availablePriorities.removeAll(usedPriorities);
        if (availablePriorities.size() == 0)
        {
            throw new RuntimeException(String.format(
                "All priority values between %d and %d "
                    + "are already taken by other cards", lowPriority,
                highPriority));
        }
        List<Integer> priorities = new ArrayList<Integer>(availablePriorities);
        int index = random.nextInt(priorities.size());
        this.priority = priorities.get(index);
        usedPriorities.add(this.priority);
    }

}