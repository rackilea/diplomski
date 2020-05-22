final long ms;
   final float sec;

   ms = System.currentTimeMillis();
   sec = ms / 1000.0f;
   System.out.format("%.3f", sec);