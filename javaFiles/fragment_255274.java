public void updateText(final String text) {       
        runOnUiThread(new Runnable() {
                    public void run(){                                               
                        TextView txtView = (TextView)findViewById(R.id.txt_status);
                        txtView.setText(text);
                    }
                });
    }