@Test
public void testSinMin() {
    UnivariateFunction f = new Sin();
    UnivariateOptimizer optimizer = new BrentOptimizer(1e-10, 1e-14);

    Assert.assertEquals(3 * Math.PI / 2, 
        optimizer.optimize(new MaxEval(200),
                           new UnivariateObjectiveFunction(f),
                           GoalType.MINIMIZE,
                           new SearchInterval(4, 5)).getPoint(), 1e-8);

    Assert.assertTrue(optimizer.getEvaluations() <= 50);
    Assert.assertEquals(200, optimizer.getMaxEvaluations());
    ...
}