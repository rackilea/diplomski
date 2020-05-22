static class Basic {
    public Basic()
    {
        doSomethingImpl();
    }

    public void doSomething()
    {
        doSomethingImpl();
    }

    private void doSomethingImpl()
    {
        System.out.println("Doing something old");
    }
}