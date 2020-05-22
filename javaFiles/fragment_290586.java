public boolean isValidDNA(String dna){
  Boolean result = true;
  // Add an extra check for the "at least one character" thing.
  for (int i=0; i<dna.length(); i++){
    if (dna.charAt(i)!='A' && dna.charAt(i)!='T' && dna.charAt(i)!='C' && dna.charAt(i)!='G' ){
        result = false;
    }
  }
  return result;
}