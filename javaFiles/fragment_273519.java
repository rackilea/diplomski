List<String> list=new ArrayList<String>();
int chunkSize=5;
for (int i=0; i<strings.size; i++) {
  int lastChunk = strings[i].length() % chunkSize;
  int chunks=strings[i].length() / chunkSize;
  for (int j=0; j<chunks; j++) {
    list.add(strings[i].substring(j*chunkSize,j*chunkSize+chunkSize);
  }
  if (lastChunk > 0) {
    list.add(strings[i].substring(chunks*chunkSize, chunks*chunkSize+lastChunk);
  }
}