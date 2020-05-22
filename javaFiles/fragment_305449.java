Document d  = createSeedData();

for (Map.Entry<String, String> entry : d.entrySet())
{
    System.out.println(entry.getKey() + "/" + entry.getValue());
}