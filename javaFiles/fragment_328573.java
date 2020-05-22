public void parseCommands(String fileName)
   {
     try
     {
       //not working, why? It works if I do FileReader fr= new FileReader("hi.tpl").
       FileReader fr= new FileReader(fileName);

     }
  }

public static void main (String[] args)// args holds the filename to be given to FileReader
 {
  if (args.length==0)
   {
     System.out.println("Error: Bad command or filename. Syntax: java [filename.tpl]);
     System.exit(0)
   }
   StringSplit ss= new StringSplit();
   ss.parseCommands(args[0]);
  }