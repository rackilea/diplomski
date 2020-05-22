s[i].acquire();
try {
   a[i]++;
} finally {
   s[i].release();
}