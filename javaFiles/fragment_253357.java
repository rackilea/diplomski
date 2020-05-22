if((align = getAlignTarget(aLine)) != -1)
{
   if(align < curLine)
   {
      if(curLine != 0)
      {
          out.write(10);
      }
      out.write("/* <-MISALIGNED-> */ ");
      out.write(aLine);
      curLine++;
   }
   else if(align == curLine)
   {
      out.write(aLine);
   }
   else
   {
      for(; align > curLine; curLine++)
      {
          out.write(10);
      }
      out.write(aLine);
   }