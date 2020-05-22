public class Second_Fragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView2 = inflater.inflate(R.layout.second_layout, container, false);
        //click button
        TextView clickFirstButton = (TextView) myView2.findViewById(R.id.uae);
        clickFirstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // launch the ping process in a separate thread
                new Thread(pingUAE).start();
            }
        });
        return myView2;
    }

    void setPingResult(int id, long pingtime) {
           TextView textView = (TextView)myView2.findViewById(id);
           if (pingtime >= 0) {
               textView.setText("server on, ping is: " + pingtime + "ms");
           }
           else {
               textView.setText("server off ");
           }
    }


    public Runnable pingUAE = new Runnable() {
        @Override
        public void run() {
            // initialise time to -1
            uae = -1;
            Runtime runtime = Runtime.getRuntime();
            try {
                long a = System.currentTimeMillis() % 1000;
                Process ipProcess = runtime.exec("/system/bin/ping -c 1 8.8.8.8");
                int     exitValue = ipProcess.waitFor();
                uae = System.currentTimeMillis() % 1000 - a;
            } catch (IOException e)          { e.printStackTrace(); }
            catch (InterruptedException e) { e.printStackTrace(); }

            // update the ping result - we need to call this on the UI thread 
            // because it updates UI elements (TextView)
            getActivity().runOnUIThread(new Runnable() {
                @Override
                public void run() {
                    setPingResult(R.id.uae, uae);
                }
            });

        }
    }

}