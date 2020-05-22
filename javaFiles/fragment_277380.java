import java.util.Set;

class TestStuff {

    public static void main(String[] args) {
        Set<Thread> threadSet = Thread.getAllStackTraces().keySet();
        for (Thread thread : threadSet) {
            if(thread.getName().equals("some-name")){
                thread.interrupt();
            }
        }
    }
}