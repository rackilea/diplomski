@Override
    public void run() {
           runOnUiThread(new Runnable(){
                @Override
                public void run() {
                     tv.setText("why?");
                }});
           }
    }