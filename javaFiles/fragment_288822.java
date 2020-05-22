private void generateDailyChart(){
    mContents.saveGraphicsState();
    int totalVal = 0;
    try {
        mContents.transform(Matrix.getTranslateInstance(375, 525));
    }catch(IOException e){}

    for (int i=1; i< 8;i++){
        totalVal += mDayPercent[i];
        writeTheChart(mDayPercent[i-1], totalVal,mColor[i]);
        log.info("Color selected = " +mColor[i] +"Index = "+i);
    }
    mContents.restoreGraphicsState();
}