public class TestPowerSet2
{
    public static void main(String[] args)
    {
        Set<Integer> set = new LinkedHashSet<Integer>(Arrays.asList(0,1,2));

        List<Set<Integer>> resultA = PowerSet.getAllCombinationsOfSubsets(set);
        System.out.println("Result A:");
        for (Set<Integer> s : resultA)
        {
            System.out.println("    "+s);
        }

        List<Set<Integer>> resultB = PowerSet.powerset(set);
        System.out.println("Result B:");
        for (Set<Integer> s : resultB)
        {
            System.out.println("    "+s);
        }
    }
}