@Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            // Calling the method from Second Class
            myotherclass = new Second(this); // <----- this
            myotherclass.toast_method();


        }