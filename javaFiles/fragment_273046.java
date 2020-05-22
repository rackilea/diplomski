int i1=0;
int i2=0;
int i3=0;
int n = a1.length + a2.length + a3.length;
for( int k = 0;  k < n; k++) {
  int advance = 0;
  int value = Integer.MAX_VALUE;
  if (i1 < a1.length && a1[i1] <= value) {
    advance = 1;
    value = a1[i1]; 
  }
  if (i2 < a2.length && a2[i2] <= value) {
    advance = 2;
    value = a2[i2]; 
  }
  if (i3 < a3.length && a3[i3] <= value) {
    advance = 3;
    value = a3[i3]; 
  }
  a[k] = value;
  switch(advance) {
  case 1: i1++; break;
  case 2: i2++; break;
  case 3: i3++; break;
  }
}