public static void main(String args[]){
test t1= new test();
t1.test1();
try {
    t1.join();
} catch (InterruptedException e1) {
    // TODO Auto-generated catch block
    e1.printStackTrace();
}
try{
    for(int i=1; i<=10; i++){
        System.out.println("Thread Two "+i);
        Thread.sleep(200);

    }

}
catch(InterruptedException e){
    System.out.println("Thread Two Interrupted");
}
System.out.println("Exiting Thread Two");