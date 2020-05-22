private AdkPort mbed;
...
public void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
            ...
            mbed = new AdkPort(this);
            Thread thread = new Thread(mbed);
            thread.start();
            mbed.attachOnNew(new AdkPort.MessageNotifier(){ 
        @Override
        public void onNew()
        {
            byte[] in = mbed.readB();
                            // Do something with the data
                    }
            });
            ...
   }