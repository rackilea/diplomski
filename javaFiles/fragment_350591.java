int numb = 10 + (int) (Math.random() * 20);
Object[] a = new Object[numb];
for (int i = 0; i < a.length; i++) {
    if (i < (int)(a.length * 0.4))
        a[i] = x;
    else if (i >= (int)(a.length * 0.4) && i < (int)(a.length * 0.7))
        a[i] = y;
    else
        a[i] = z;
}