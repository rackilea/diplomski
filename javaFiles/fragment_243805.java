String line;
List<String> list = new ArrayList<String>();
while((line = reader.readLine()) != null)
{
    if(line.startsWith("--"))
        continue;
    list.add(line);
}

for(int i = 0; i < list.length; i++)
{
    line = list.get(i);
    // use regular expressions to extract the data you want to convert into CSV format
}