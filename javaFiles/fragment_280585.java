int i, j, n, flag;
  char str[128];

  printf ("\nEnter string: ");
  scanf ("%s", &str);
  n = strlen (str);


for (flag=1, i=n-1, j=0; j<n/2; j++, i--)
{
  if (str[i] != str[j])
  {
    flag = 0;
    break;
  }
}

if (flag)
 printf ("\n\"%s\" is a palindrome");
else
 printf ("\n\"%s\" is not a palindrome");