public void video_play(){

            VideoView vview= (VideoView)findViewById(R.id.vview);
            vview.setVideoURI(Uri.parse(prepare.txtLectureFileName[index_value]));
            vview.setMediaController(new MediaController(this));
            vview.requestFocus();
            vview.start();
            if(index_val>=no_of_videos){
                Toast.makeText(getApplicationContext(), "Videos are finished", Toast.LENGTH_SHORT).show();
            }
            else{
                 video_play();
            }
            vview.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion (MediaPlayer mp) {
                index_value++;
                video_play();
            }
        });
}