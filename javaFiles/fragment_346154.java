Calendar calendar = Calendar.getInstance();

if (calendar.get(Calendar.HOUR_OF_DAY) >= 21)
{
    System.out.println("Diasble it.");
}
else
{
    System.out.println("Enable it.");
}