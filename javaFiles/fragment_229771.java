b.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                if(mp.isPlaying())
                {  
                    mp.stop();
                }else{
                try {
                    mp.reset();
                    AssetFileDescriptor afd;
                    afd = getAssets().openFd("sound/07.mp3");
                    mp.setDataSource(afd.getFileDescriptor(),afd.getStartOffset(),afd.getLength());
                    mp.prepare();
                    mp.start();
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

}

            }
        });