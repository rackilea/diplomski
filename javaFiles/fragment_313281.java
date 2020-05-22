class test{
    public static boolean isMainThread(){
        return Thread.currentThread().getId() == 1;
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