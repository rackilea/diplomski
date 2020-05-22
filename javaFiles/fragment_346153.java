DateTime now = DateTime.now();

if (now.getHourOfDay() >= 21)
{
    System.out.println("Disable it.");
}
else
{
    System.out.println("Enable it.");
}