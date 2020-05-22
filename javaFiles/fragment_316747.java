String str = "...";
// suppose str becomes null after some operation(s).
int number = 0;
try
{
    if(str != null)
      number = Integer.parseInt(str);
}
catch (NumberFormatException e)
{
    number = 0;
}