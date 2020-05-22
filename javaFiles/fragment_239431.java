OrthographicCamera mStageCamera;
OrthographicCamera mFixedCamera;
SpriteBatch mBatch;

@Override
public void render() {
    mBatch.setProjectionMatrix(mFixedCamera.combined);
    mBatch.begin();
    //render "static" elements
    mBatch.end();

    mBatch.setProjectionMatrix(mStageCamera.combined);
    mBatch.begin();
    //render "movable" elements
    mBatch.end();
}