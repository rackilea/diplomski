List<String[]> list = new ArrayList<String[]>();
String str;
while((str = br.readLine()) != null)
{
    String[] array = str.split("\t");
    list.add(array);
}
String[][] array2D = new String[list.size()][];
list.toArray(array2D);