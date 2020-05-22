if (((i % 2 == 0) || (j >= b.length)) && (j < a.length))
 {                 //^^^ 
    interleave[i] = a[j];
    j++;
 }
 if (((i % 2 == 1) || (k >= a.length)) && (k < b.length))
 {                  //^^^
    interleave[i] = b[k];
    k++;
 }