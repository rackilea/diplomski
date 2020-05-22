// define some constant which can be used in the anonymous class:
final String someStr = "whatever";

new Thread(new Runnable() {
    @Override
    public void run() {
        // use the String someStr directly
        System.out.println(someStr);
    }
}).start();