private void rev(int first, int last)
{
   if(first < last)
   {
      var temp = a[first];
      a[first] = a[last];
      a[last]  = temp;
      rev(first + 1, last - 1);
   }
}