String url = "http://example.com/games/play cricket.mp3"; 
String fixedUrl = url.replaceAll("\\s", "%20");

MediaPlayer mp = new MediaPlayer();

try {
    mp.setDataSource(fixedUrl);
    mp.prepare();
    mp.start();
} catch (Exception e) {
    e.printStackTrace();
}