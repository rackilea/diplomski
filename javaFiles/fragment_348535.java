@Override
    public void run() {
           tv.post(new Runnable(){
                @Override
                public void run() {
                     tv.setText("why?");
                }});
           }
    }