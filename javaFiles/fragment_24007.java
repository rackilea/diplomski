public void performAISequence (){

        //Get a sequence action from the pool (to avoid unnecessary allocation)
        //and give it the first action
        SequenceAction sequence = Actions.sequence(Actions.touchable(Touchable.disabled));

        for (int i = 0; i < XimonGame.computerList.size(); i++) {

            if (code == XimonGame.computerList.get(i)) {
                sequence.addAction(Actions.runnable(playSoundRunnable));
                sequence.addAction(Actions.hide());
            }

            //Want to delay it for every item in list, because it may need to wait for other buttons
            sequence.addAction(Actions.delay(BUTTON_DELAY_TIME));

            if (code == XimonGame.computerList.get(i)) {
                sequence.addAction(Actions.show());
                sequence.addAction(Actions.runnable(stopSoundRunnable));
            }

            sequence.addAction(Actions.touchable(Touchable.enabled));

        }

        this.addAction(sequence);

    }

Runnable playSoundRunnable = new Runnable(){
    public void run(){
        sound.play(0.4f);
    }
};

Runnable stopSoundRunnable = new Runnable(){
    public void run(){
        sound.stop();
    }
};