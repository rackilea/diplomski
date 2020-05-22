Scanner in = new Scanner(System.in);
  System.out.println("please enter string");
  String strName = in.nextLine();
  int ap = 0;
  char strArray[] = new char[strName.length()];

  for(int i=0;i < strName.length();i++)
  {
   strArray[ap] = strName.charAt(i);
   ap++;
  }
 for (int e=strArray.length-1;e >= 0;e--)
 {
   System.out.print(strArray[e]);
 }