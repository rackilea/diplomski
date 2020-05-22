public RobotOne(PlayScreen playScreen, Rectangle rect, boolean right){
        ...

        timer = 0;
        TextureRegion[][] tmp = TextureRegion.split(Assets.instance.animationSheet,Assets.instance.animationSheet.getWidth() / cols, Assets.instance.animationSheet.getHeight() / rows);
        TextureRegion[] animationFrames = new TextureRegion[cols * rows];
        int index = 0;
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                animationFrames[index++] = tmp[i][j];
            }
        }
        ownAnimation = new Animation<TextureRegion>(1/15f, animationFrames, Animation.PlayMode.LOOP)
        region = ownAnimation.getKeyFrame(timer);

        ...
    }