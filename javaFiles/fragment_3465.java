String testData = "0001,48;0451,0605\\,230001;0431,0605230002;";
String[] array = testData.split("(?<=[^\\]);");
for(int i = 0; i < array.length; i++)
{
    System.out.println(array[i]);
}