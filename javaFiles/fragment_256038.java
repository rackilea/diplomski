private UpdateInterface listner;

public interface UpdateInterface {
    void recyclerviewOnUpdate(int amount);
}

public VideoAdapter(Context context, ArrayList<PathModel> thumbPathList, ArrayList<PathModel> videoPathList, UpdateInterface listner) {
    this.context = context;
    this.thumbPathList = thumbPathList;
    this.videoPathList = videoPathList;
    //I added this
    this.listner=listner;
}