catch(Exception JavaInputMismatch)
{
    sc.next(); // clear the bad token. Without this, it loops infinitely.
    System.out.println("Option not available.Try again.");
    datatype=false;
}