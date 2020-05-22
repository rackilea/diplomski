@Override
public void run() {

    for ( ;;  ) {
        synchronized( lock ) {
            if( i.incrementAndGet() <= 100000 ) {
                value_to_be_incremented_stored.incrementAndGet();
                map.put("TC", value_to_be_incremented_stored.intValue());
            }
            else
                break;
        }
    }
    System.out.println("Output by Thread  " + Thread.currentThread() 
            + "     " + map.toString());
}