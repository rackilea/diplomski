final Runnable r = new Runnable() {
        public void run() {
            TextView myTextView = (TextView) findViewById(R.id.Flow1);
            random flow1=new random();
            myTextView.setText("Flow: " + flow1.random() + " m" + Html.fromHtml("<sup><small>" + "3" + "</small></sup>"));
            myTextView.postDelayed(this, 9000);
        }
    };