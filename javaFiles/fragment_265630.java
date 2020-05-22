for (File f : f.listFiles())
{
  if (!f.isHidden())
  {
    System.out.println(f.getName());
  }
}