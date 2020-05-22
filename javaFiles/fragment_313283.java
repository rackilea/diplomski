class AnotherClass{
    static long mainThreadId = Thread.currentThread().getId();

    public static boolean isMainThread(){
        return Thread.currentThread().getId() == mainThreadId;
    }
}
class test{
    public static void main(String[]args){
        //System.out.println(isMainThread());
        new Thread( new Runnable(){
            public void run(){
                System.out.println(AnotherClass.isMainThread());
            }
        }).start();
    }
}