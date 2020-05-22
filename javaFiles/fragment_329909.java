public void ClickedLearn(View v){
    create_connection();
    Handler communication=new Handler();
    communication.postDelayed(new Runnable() {
        @Override
        public void run() {
            request_packet();
            Handler handler=new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    recieve_packet();
                    if(isLearned){
                        Savebtn.setVisibility(View.VISIBLE);
                    }
                    try {
                        client.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            },500);
        }
    },1000);
}