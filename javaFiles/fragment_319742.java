public static void main(String[] args)
{
  if (args.length == 1)
  {
    hex_to_dec data = new hex_to_dec(args[0], args[0] + ".dec");
    data.Parse();
  }
}