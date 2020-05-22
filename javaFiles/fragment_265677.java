public static int parseInt(final String input,final int radix)
  {
  int output=0;
  for(int i=0;i<input.length();++i)
    {
    output*=radix;
    final char c=input.charAt(i);
    if(c>='a')
      output+=c-'a'+10;
    else output+=c-'0';
    }
  return output;
  }