@RequestMapping(value = "/exec", method = RequestMethod.GET)
public void execute(){
    int i = 0;
    for (i; i < 10; i++;){
        B b = factory.getB();
        b.setMyParameter(i);
        executor.submit(b);
    }
}