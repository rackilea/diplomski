for(int i=0; i < 100; i++) {
   if (bigbuffer[i] != bigbuffer[i+100]) {
       System.out.println("Not Equal");
       break;
   }
}