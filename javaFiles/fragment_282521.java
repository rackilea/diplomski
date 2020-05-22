long[] delta = new long[ar];
for(i=0;i<k;i++)
{
    l=sc.nextLong();
    r=sc.nextLong();
    v=sc.nextLong();

    if (l-1 < r) {
        m=(int)(l-1);
        delta[m] = v;

        m=(int)r;
        if (m < delta.length) {
          delta[m] = -v;
        }
    }
}

long cumulative = 0;
for (int a = 0; a < ar.length; ++a) {
  cumulative += delta[a];
  ar[a] += cumulative;
}