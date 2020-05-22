public static void enqueuer()
{
    String p;
    do {
        p = input1.next();
        if (!p.equals("stop"))
           potato.enqueue(p);
    } while(!p.equals("stop"));
}