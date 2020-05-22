//creates a task which will retry 3 times with an interval of 5 seconds
RetriableTask r = new RetriableTask(3, 5000, new Callable(){
    public Object call() throws Exception{
        //put your code here
    }
});
r.call();