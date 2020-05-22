private static final class MyCallable implements Callable<String>{

    @Override
    public String call() throws Exception {
        StringBuilder builder = new StringBuilder();
        try{
            for(int i=0;i<Integer.MAX_VALUE;++i){
                builder.append("a");
                Thread.sleep(100);
            }
        }catch(InterruptedException e){
            System.out.println("Thread was interrupted");
        }
        return builder.toString();
    }
}