try {
   timer = new Timer();
   timer.schedule( new SysPrint(), 200 );
} finally {
   timer.cancel();
}