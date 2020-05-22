@Override
public void onVideoClicked(Video video) {
    Intent intent = new Intent(this, MainActivity.class); // Your youtubeplayer activity
    intent.putExtra("video_id",video_id);
    startActivity(intent);
}