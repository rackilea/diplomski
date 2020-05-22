long start = System.nanoTime();
long rate = 20000;
for(long i = 0; ; i++) {

   // do something

   long end = start + i * 1000000000L / rate;
   while(System.nanoTime() < end);
}