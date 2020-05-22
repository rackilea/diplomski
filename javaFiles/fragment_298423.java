m = n;
for (i = 31; i >= 0; i--)
{
  di = d << i;
  if (di > 0 && m >= di) m -= di;
}