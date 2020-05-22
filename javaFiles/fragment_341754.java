final String finalString = "I'm final :)";
final Integer finalInteger = new Integer(30);
final Calendar calendar = Calendar.getInstance();
Object object2 = new Object()
{
  {
    System.out.println("Instance initializing block");
    System.out.println(finalString);
    System.out.println("My integer is " + finalInteger);
    System.out.println(calendar.getTime().toString());
  }
  private void hiddenMethod()
  {
    System.out.println("Use reflection to find me :)");
  }
};