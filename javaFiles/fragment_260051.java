Runnable runnable = new Runnable() {
    int x;
    //initialization block here
    {
        //IMO this is such odd design, it would be better to not
        //create this as an anonymous class
        x = outerClassInstance.someMethod();
    }
    @Override
    public void run() {
        //write the logic here...
    }
};