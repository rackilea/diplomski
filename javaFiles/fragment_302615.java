E[] r = new E[k]; //not really, cannot create an array of generic type, but just pseudo code
int i = 0;
for (E e : list) {
   //assign first k elements:
   if (i < k) { r[i++] = e; continue; }
   //add current element with decreasing probability:
   j = random(i++) + 1; //a number from 1 to i inclusive
   if (j <= k) r[j] = e;
}
return r;