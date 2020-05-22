List<String> arrayList = new ArrayList<String>();
arrayList.add("a");
arrayList.add("b");
arrayList.add("c");
arrayList.add("d");

int i = 0, size = arrayList.size();
while (i < size)
{
    String col1 = arrayList.get(i);
    String col2 = ",";
    i++;
    if (i < size)
    {
        col2 += arrayList.get(i);
    }

    writer.write(col1 + col2);

    // put a new line here
    writer.write(System.getProperty("line.separator"));

    i++; // go to the next one
}