class Wrapper {
  private List<List<Gene>> chunks;
  Gene get(long id) {
    int chunkId = id / Integer.MAX_VALUE;
    int itemId = id % Integer.MAX_VALUE;
    List<Gene> chunk = chunks.get(chunkId);
    return chunk.get(itemId);
  }
}