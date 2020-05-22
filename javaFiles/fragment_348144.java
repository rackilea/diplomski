runOnUiThread(new Runnable() {
        public void run() {
            while(line!= null){

                textview.setText(sb.toString());
                //...

                Thread.sleep(200) //let other processes have some cpu
                }
            });
        }
    });