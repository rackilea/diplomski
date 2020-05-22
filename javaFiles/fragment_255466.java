static boolean isPermutation(char[] w, char[] k) {
  int k_idx=0;
  for(w_idx=0; w_idx < w.length; ++w_idx) {
    if(k_idx == k.length)
      return true; // all characters in k are present in w
    if( w[w_idx] > k[k_idx] )
      return false;  // found character in k not present in w
    if( w[w_idx] == k[k_idx] )
      ++k_idx;  // character from k corresponds to character from w
  }
  // any remaining characters in k are not present in w
  return k_idx == k.length;
}