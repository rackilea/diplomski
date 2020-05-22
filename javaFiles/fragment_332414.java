protected void setScale(float scale, boolean updateView) {
    mScale = scale;
    if (updateView) {
        LayoutParams params = getLayoutParams();
        onUpdateScale(scale, params);
        setLayoutParams(params);
    }
}

protected void onUpdateScale(float scale, LayoutParams params) {
    params.leftMargin = (int) (mModel.getX() * scale);
    params.topMargin = (int) (mModel.getY() * scale);
    params.width = (int) (mModel.getWidth() * scale);
    params.height = (int) (mModel.getHeight() * scale);
}