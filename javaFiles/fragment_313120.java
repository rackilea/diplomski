@Override
public void onResponse(Response response) throws IOException {
    try {
        ...
        for (int i = counter; i <= loadLimit; i++) {
            if (videoDataList == null) {
                return;
            } else {
                VideoData next_queue_id = new VideoData(videoDataList.get(i));
                videoList.add(next_queue_id);
                counter++;
            }
        }
        ListVideo.this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                adapter.notifyDataSetChanged();
            }
        });
    } catch (Exception e) {
        e.printStackTrace();
    }
}