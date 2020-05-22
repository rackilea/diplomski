Uri uri = Uri.parse(path);
Map<String, String> headers = new HashMap<String, String>();
headers.put("key1", "value1");
headers.put("key2", "value2");

mMediaPlayer = new MediaPlayer();
// Use java reflection call the hide API:
Method method = mMediaPlayer.getClass().getMethod("setDataSource", new Class[] { Context.class, Uri.class, Map.class });
method.invoke(mMediaPlayer, new Object[] {this, uri, headers});
mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
mMediaPlayer.prepareAsync();

... ...