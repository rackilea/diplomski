public void doTask(String arg1, String... arg2) {
    // do a bunch of things
    smallstep(arg1, arg2);
    // do another bunch of things
}

public void smallstep(String arg1, String... arg2) {
    String arg = arg2.length == 0 ? "some default" : arg2[0];
    // do stuff
}