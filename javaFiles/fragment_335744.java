public static void main (String[] args) throws java.lang.Exception
{
    List<Class<? extends Enum>> myEnums = new ArrayList<>();
    myEnums.add(Outlook.class);
    myEnums.add(Temperature.class);
    myEnums.add(Humidity.class);
    System.out.println(myEnums);
}

enum Outlook {
    SUNNY, RAINY, CLOUDY
}
enum Temperature {
    HOT, COLD, MILD
}
enum Humidity {
    HIGH, NORMAL, LOW
}