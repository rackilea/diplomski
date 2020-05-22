playButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        if (playShow) {
                            playButton.setBackgroundResource(R.drawable.play_pressed);
                        } else {
                            playButton.setBackgroundResource(R.drawable.pause_pressed);
                        }
                        return true; //handle the touch event
                    case MotionEvent.ACTION_UP:
                        if (playShow) {
                            playButton.setBackgroundResource(R.drawable.pause_default);
                            anim = ObjectAnimator.ofFloat(imageRound, "rotation", imageRound.getRotation(), 360f);
                            anim.setDuration(20000);
                            anim.setInterpolator(new LinearInterpolator());
                            anim.start();//
                            playShow = false;
                            if (mediaPlayer != null) {
                                mediaPlayer.start();
                            }

                        } else {
                            playButton.setBackgroundResource(R.drawable.play_default);
                            anim.cancel();                             
                            playShow = true;
                            if (mediaPlayer != null) {
                                mediaPlayer.pause();
                            }

                        }
                        return true; // handle the touch event
                }
                return false;
            }
        });