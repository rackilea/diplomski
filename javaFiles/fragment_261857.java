int c = 1;
int line = 1, col = 1;
while (c <= i) 
{
  if (string.charAt(c) == '\n')
  {
    ++line;
    col = 1;
  } else {
    ++col;
  }
}