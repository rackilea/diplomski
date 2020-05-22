String a="Iam in the world of abc";
        String b="world";

  for(int i=0;i<a.length()-b.length();i++)
  {
   //System.out.println(i);

    if(a.substring(i,b.length()+i).equals(b))
  {
     System.out.println("true s");
     System.out.println(a.substring(i,b.length()+i));
  }


        }