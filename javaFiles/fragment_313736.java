String appendIfNotPresent(String initial, String curr)
{
   if (initial.contains(curr))
     return initial;
   else
     return initial + curr;
}