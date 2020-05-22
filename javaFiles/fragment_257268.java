class Call {
    public Call() {}

    private static void delay(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            // keep out!
        }
    }

    private void call(char a, String msg, char b) {
        synchronized (this) {
            System.out.print(a);
            System.out.print(msg);
            delay(100);
        }
        delay(ThreadLocalRandom.current().nextInt(10) * 10); // probability
        System.out.println(b);
    }

    void callA(String msg) { call('[', msg, ']'); }
    void callB(String msg) { call('{', msg, '}'); }
    void callC(String msg) { call('(', msg, ')'); }
}

public class Callme {
    static Call call = new Call();
    static List<Consumer<String>> calls = asList(call::callA, call::callB, call::callC);

    static void randomCall() {
        calls.get(ThreadLocalRandom.current().nextInt(calls.size())).accept("Hello!");
    }
    public static void main(String... args) {
        IntStream.range(0, 50).forEach(ignore -> new Thread(Callme::randomCall).start());
    }
}