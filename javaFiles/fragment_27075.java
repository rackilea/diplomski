public Inteface Callback {
    public void complete();
}

public class Ticker {
    public void test(Callback callback) {
        // tick, tick, tick
        callback.complete();
    }
}

public class User implements Callback {
    public void complete() {
        ...
    }

    public void useTicker() {
        Ticker ticker = new Ticker();
        ticker.test(this);
    }
}