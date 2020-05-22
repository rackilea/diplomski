public void bidirectionalBubbleSort()
    {
       int left = 0, right = a.length-1;
       while (left < right)
       {
          for (int pos = left; pos < right; pos++)
          {
             if (a[pos] > a[pos+1])
                swap(pos, pos+1);
          }
          right--;


          for (int pos = right; pos > left; pos--)
          {
             if (a[pos] < a[pos-1])
               swap(pos, pos-1);
          }
          left++;
       }
   }