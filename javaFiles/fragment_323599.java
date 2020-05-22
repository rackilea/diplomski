mContext.runOnUpdateThread(new Runnable() {

    public void run() {
        SceneManager.mWorldScene.detachChild(logSprite);
    }

});