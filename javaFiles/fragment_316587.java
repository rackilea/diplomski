public static boolean disco(boolean[] init, boolean[] target)  
{  
  return recurse(init,boolean,0);  
}  

public static boolean recurse(boolean[] init, boolean[] target, int min)  
{  
  if (min == init.length)  
    if (init == target)  
      return true;  
    else  
      return false;  
  boolean[] temp = "init with a change at min";  
  boolean a = recurse(init, target, min+1);  
  boolean b =   recurse(temp, target, min+1);  
  return a||b;
}