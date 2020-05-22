int blockSize   = 2048/8;
int outputIndex = 0;
for(int j = 0;j<8;j++){
  for(int i = 0;i<blockSize;i++){
    baseband[outputIndex] = 2*encodedBit[j]-1;
    outputIndex++;
  }  
}