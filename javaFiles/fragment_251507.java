else if(args.length == 3)
{
   String firstLine = (args[0]);
   String secondLine = (args[1]);
   String thirdLine = (args[2]);

   Open open = new Open(firstLine,secondLine,thirdLine);
   open.display();
}