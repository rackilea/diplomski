class Test extends GWTTestCase{
    @Test
    public void testSomething{
        Runnable onLoadCallback = new Runnable() {
            public void run() {
                ...
            }
        };

        VisualizationUtils.loadVisualizationApi(onLoadCallback, Table.PACKAGE);
    }
}