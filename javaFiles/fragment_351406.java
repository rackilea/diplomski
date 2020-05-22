playButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            try{

                Uri myUri = Uri.parse("android.resource://" + v.getContext().getPackageName() + "/" + R.raw.sleep_away);
                System.out.println(myUri);
                playerM.setDataSource(v.getContext(), myUri);
                playerM.prepare();
                playerM.setOnPreparedListener(new MediaPlayer.OnPreparedListener(){
                    @Override
                    public void onPrepared(MediaPlayer playerM){
                        playerM.start();
                    }
                });
            }catch(IOException e){
                e.printStackTrace();
            }


        }
    });