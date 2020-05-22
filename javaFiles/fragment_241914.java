public static void main(String[] args) {
    new Thread() { 
        public void run() {
            method1();
        }
    }.start();
    new Thread() { 
        public void run() {
            method2();
        }
    }.start();
    //etc

    //or, as kingdamian42 pointed out, if you use java8, use this
    new Thread(() -> method1()).start();
    new Thread(() -> method2()).start();
}