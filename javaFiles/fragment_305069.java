int[] res = new int[a.length + b.length];
int p = 0;
//zip what we can
int last = Math.min(a.length, b.length);    
for (int i = 0; i != last; i++) {
    res[p++] = a[i];
    res[p++] = b[i];
}
//now add the remaining
int aRemain = a.length - last;
if(aRemain > 0) {
  System.arrayCopy(a, last, res, p, aRemain);
}
else
{
  int bRemain = b.length - last;
  if(bRemain > 0) {
    System.arrayCopy(b, last, res, p, bRemain);
  }
}