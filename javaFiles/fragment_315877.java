int j = 0;
for(T t : b) {
  if (a.equals(t)) {
    return j;
  }
  j++;
}
return -1;