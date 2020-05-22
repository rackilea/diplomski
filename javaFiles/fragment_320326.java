public int getRandom(){
  // Here i am asking for a random number between 0 and 1, multiplying by 6, rounding 
  // it down, and explicitly casting to int.
  // Result will be random int between 0 and 5. This will be the array index that 
  // randomly chooses the song.  
    private int randomIndex;
    randomindex = (int) Math.floor(6 * Math.random);
    return this.audioFiles[randomIndex];
}