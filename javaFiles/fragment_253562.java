public boolean linearIn(int[] outer, int[] inner) {
  int i = 0;

  if(inner.length == 0) return true;

  for(int o = 0; o < outer.length; o++){
    if(inner[i] == outer[o]) i++;
    if(i == inner.length) return true;
  }
  return false;
}