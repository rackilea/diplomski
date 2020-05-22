public class TestHashTable
{
    @Test
    public void testEmpty()
    {
        final Cluster c1 = new Cluster();
        final Cluster c2 = new Cluster();
        Assert.assertEquals(c1, c2);
        Assert.assertEquals(c1.hashCode(), c2.hashCode());
    }

    @Test
    public void testSame()
    {
        final Payoff pay1 = new Payoff();
        final Cluster cluster1 = new Cluster();
        cluster1.dataArray.addAll(java.util.Arrays.asList(1,2,3));
        pay1.coalitions.add(cluster1);

        Assert.assertEquals(pay1, pay1);
        Assert.assertEquals(pay1.hashCode(), pay1.hashCode());
    }   

    @Test
    public void testEquals()
    {
        final Payoff pay1 = new Payoff();
        final Cluster cluster1 = new Cluster();
        cluster1.dataArray.addAll(java.util.Arrays.asList(1,2,3));
        pay1.coalitions.add(cluster1);

        final Payoff pay2 = new Payoff();
        final Cluster cluster2 = new Cluster();
        cluster2.dataArray.addAll(java.util.Arrays.asList(1,2,3));
        pay2.coalitions.add(cluster2);

        Assert.assertEquals(cluster1, cluster2);
        Assert.assertEquals(pay1, pay2);

        Assert.assertEquals(cluster1.hashCode(), cluster2.hashCode());
        Assert.assertEquals(pay1.hashCode(), pay1.hashCode());
    }

    @Test
    public void testUseInMap()
    {
        final Payoff pay1 = new Payoff();
        final Cluster cluster1 = new Cluster();
        cluster1.dataArray.addAll(java.util.Arrays.asList(1,2,3));
        final double[] a1 = {1.5};
        cluster1.ch = a1;
        pay1.coalitions.add(cluster1);

        final Payoff pay2 = new Payoff();
        final Cluster cluster2 = new Cluster();
        final double[] a2 = {1.5};
        cluster2.ch = a2;
        cluster2.dataArray.addAll(java.util.Arrays.asList(1,2,3));
        pay2.coalitions.add(cluster2);

        final Map<Payoff, Double> map = new HashMap<Payoff, Double>();
        map.put(pay1, 1.0);
        map.put(pay2, 2.0);

        Assert.assertEquals(1, map.size());
        Assert.assertTrue(2.0 == map.get(pay1));
    }
}