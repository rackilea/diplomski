MediaSource[] mediaSources = new MediaSource[arrayList.size()];
for (int i = 0; i < arrayList.size(); i++) {
    String string = arrayList.get(i);
    Log.d("string::", string+", "+String.valueOf(i));
    mediaSources[i] = buildMediaSource(Uri.parse(string));
}
mediaSource = new ConcatenatingMediaSource(mediaSources);