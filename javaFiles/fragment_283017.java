public class myClass {
    OnStartListener myListener;

    public myClass(OnStartListener myListener) {
             this.myListener = myListener;
        }
    public void test() {
            //here I want to trigger `onStartListener`
            myListener.onStart();
    }

        interface OnStartListener {
            public void onStart();
    }
}