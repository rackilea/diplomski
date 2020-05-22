final int CHUNK_SIZE = 50;

for (int i = 0; i < idsVideos.size(); i += CHUNK_SIZE) {
  List<String> chunk = idsVideos.subList(i, Math.min(i + CHUNK_SIZE, idsVideos.size()));
  ..
}