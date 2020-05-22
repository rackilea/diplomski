public static void transfer(DeadLock from, DeadLock to,double d) {
    synchronized(from) {
        try {
            System.out.println(Thread.currentThread().getName() +" acquires lock " +from);
            Thread.sleep(5000);
            synchronized(to) {
                System.out.println(Thread.currentThread().getName() +" acquires lock " +to);
                from.withdraw(d);
                to.deposit(d);
                System.out.println("Done");
            }
        }catch(Exception e){}
    }
}