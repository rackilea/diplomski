@Override
public void onReceive(Object message) throws Exception {
    MyResult res = doStuff(message);
    // send result back
    getSender().tell(res, getSelf());
}