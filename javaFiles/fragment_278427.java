int maxlength = max(a.length, b.length)

Vector c = ... // create Vector of maxlength length

for (int i = 0; i < maxlength; i++)
{
  if (i < a.length)
  {
    c[i] += a[i];
  }
  if (i < b.length)
  {
    c[i] += b[i];
  }
}