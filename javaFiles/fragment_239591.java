package CInterface; 

import com.sun.jna.Library; 

public interface CInterface extends Library 
{ 
      public int puts(String str);
}