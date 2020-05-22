class test{

    static long mainThreadId = Thread.currentThread().getId();

    public static boolean isMainThread(){
        return Thread.currentThread().getId() == mainThreadId;
    }

    public static void main(String[]args){
        System.out.println(isMainThread());
        new Thread( new Runnable(){
            public void run(){
                System.out.println(isMainThread());
            }
        }).start();
    }
}