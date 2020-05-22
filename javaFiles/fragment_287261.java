int res = 0;
int cur = 0;
for (int i = 0; i < a.length; i++) {
    if (i > 0 && a[i] <= a[i - 1])
        cur = 0;
    cur++;
    res = Math.max(res, cur);
}