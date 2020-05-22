long start = System.nanoTime();
for(int i=0;i<100000;i++) {
    for(int num=1;num<100;num++) {
        String text = (num < 10 ? "0" : "") + num;
    }
}
long time = System.nanoTime() - start;
System.out.println(time/99/100000);