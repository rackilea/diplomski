while(!end)
{
   consoleOutput.mark(32);
   if (consoleOutput.read()==0x03) end = true;//End of Text
   else
   { 
     consoleOutput.reset();
     consoleOutput.readLine();
     end = false;
   }
}