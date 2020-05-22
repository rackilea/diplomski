public static boolean disco(boolean[] init, boolean[] target)  
{  
  if (init.length%3 == 0 || init.length%3 == 1)
    return true;
  return recurse(init,target,0, true);
}

public static boolean recurse(boolean[] init, boolean[] target, int index, boolean even)
{
  if (index = init.length)
    return even;
  if (init[index] != target[index] && index%3 != 0)
    even = !even;
  return recurse(init, target, index+1, even);
}