package bestsss.util;

import java.util.Arrays;

public class StackInterceptor extends InheritableThreadLocal<StackTraceElement[]>{
    public static final StackInterceptor instance;
    static{
        instance = new StackInterceptor();
        instance.set(new Throwable().getStackTrace());
    }

    @Override
    protected StackTraceElement[] childValue(StackTraceElement[] parentValue) {
        return new Throwable().getStackTrace();
    }

    //test//
    public static void main(String[] args) {
        Runnable r= new Runnable(){
            @Override
            public void run() {
                System.out.printf("%s - creation stack: %s%n", Thread.currentThread(), Arrays.toString(instance.get()).replace(',', '\n'));
            }           
        };

        Thread t1 = new Thread(r, "t1");
        //spacer
        Thread t2 = new Thread(r, "t2");
        t1.start();
        t2.start();     
    }
}