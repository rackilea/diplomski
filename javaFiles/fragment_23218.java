public static void main(String[] args)
{
    if(args.length == 0) {
        // Do default here--no options specified
    } else if(args.length > 2) {
        // Complain that there are too many args, or implement multi-args
    } else // known just one arg
       if(args[1].equals("option1") {
           // call the main of your first app
       } else if(args[1].equals("option2") {
           // start your second app
      ...
   }
}