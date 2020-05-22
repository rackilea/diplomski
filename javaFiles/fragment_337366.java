public void run() {
  while(true) { // Or with a stop condition
    try {
            x = mouseLocation.x;
            y = mouseLocation.y;

            System.out.println("X:"+x+" Y:"+y+" at time "+System.currentTimeMillis());

    } catch(Exception e) {
        System.out.println("Exception caught : "+e);
    }
  }
}