long timeOutNS=TimeUnit.MINUTES.toNanos(1); // 1 min timeout
long checkNS=TimeUnit.MILLISECONDS.toNanos(200); // check input every 200ms

int input=0;
boolean hasInput=false;

readWithTimeOut: {
  System.out.println("Enter int: ");
  long deadLine=System.nanoTime() + timeOutNS;
  for(;;) {
    int a = System.in.available();
    if(a>0) {
      byte[] b=new byte[a];
      a=System.in.read(b);
      if(a<=0) break readWithTimeOut;
      Scanner scanner=new Scanner(new ByteArrayInputStream(b, 0, a));
      if(scanner.hasNextInt()) {
        input=scanner.nextInt();
        hasInput=true;
        break;
      }
      else if(scanner.hasNext())
        System.err.println("not an int: "+scanner.next()); // consumes token
      continue;
    }
    long remaining=deadLine-System.nanoTime();
    if(remaining<=0) {
      System.err.println("timeout");
      break readWithTimeOut;
    }
    LockSupport.parkNanos(Math.min(remaining, checkNS));
  }
}

System.out.println( hasInput? "entered "+input: "no valid input" );