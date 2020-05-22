String previousPassage;
OnData onDataCallback = new OnData {
    public void updateData(String data) {
        previousPassage = data;
    }
};
BackNextGo.getInstance().getPassage(currentChapter, chapterSelected, onDataCallback);