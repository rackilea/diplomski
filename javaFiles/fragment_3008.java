for (int a = 0; a < ls.size(); a++)
{
  // Get first element
  String firstE = ls.get(a);

  // Get corresponding vl elements
  List<String> vls = vl.get(a);

  // Now print the elements
  // The first element of vl should be preceeded by the corresponding element in ls
  // The others by the predecessor in the same array
  for (int b = 0; b < vls.size(); b++)
  {
    System.out.print("[");
    if (b == 0)
      System.out.print(firstE);
    else
      System.out.print(vls.get(b - 1));
    System.out.println(", " + vls.get(b) + "]");
  }

}