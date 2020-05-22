public void gen(){
    c = new Chunk();
if(c.chunkChanged == false){
    for(int i = 0; i < worldSize; i++){
        newChunk();
    }
  }
}