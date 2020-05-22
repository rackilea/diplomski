private static final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
private static final char[] scramb = alphabet.toChararray();

public static String cryptocodeM(String msg)
{
   if (null == msg || msg.isEmpty() )
      return msg;
   final StringBuilder newMsg = new StringBuilder(msg.length());
   shuffleArray(scramb);
   System.out.println(new String(scramb));
   msg = msg.toUpperCase(); 
   for (int x= 0; x < msg.length(); x++)
   {
      char a = msg.charAt(x);
      final int index = alphabet.indexOf(a);
      if (index > -1)
          a = scramb[index];
      newMsg.append(a);
   }
   return newMsg.toString();
}

public static void shuffleArray( char[] array )
{
    final Random rnd = new Random();
    for ( int i = array.length - 1 ; i > 0 ; --i )
    {
        final int index = rnd.nextInt( i + 1 );
        // Simple swap
        final char a = array[index];
        array[index] = array[i];
        array[i] = a;
    }
}