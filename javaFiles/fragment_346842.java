public static void main(String args[]) {

    String str = "abcdef";
    System.out.println(str);
    char[] chars = str.toCharArray();

    Thread t1 = new Thread(new CapitalizeString(chars, 0, 3));
    Thread t2 = new Thread(new CapitalizeString(chars, 1, 3));
    Thread t3 = new Thread(new CapitalizeString(chars, 2, 3));

    t1.start();
    t2.start();
    t3.start();

    // wait until all threads finish their work
    try{
        t1.join();
        t2.join();
        t3.join();
    }catch(InterruptedException e){ }

    // print the result
    str = String.valueOf(chars);
    System.out.println(str);
}