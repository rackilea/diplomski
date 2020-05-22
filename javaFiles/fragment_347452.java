public class Hello {

    public interface OnHelloSaidListener {
        void onHelloSaid();
    }

}

public void test() {
    sayHello(new OnHelloSaidListener() {
        @Override
        public void onHelloSaid() {
            // Do somth
        }
    });
}

public void sayHello(OnHelloSaidListener callback) {
    Toast.makeText(context, "Hello world");
    callback.onHelloSaid();
}