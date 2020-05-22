StringBuilder builder = new StringBuilder();
for (String name : names)
{
    builder.append(name);
    builder.append(", ");
}
if (builder.length() > 0)
{
    builder.setLength(builder.length() - 2);
}
System.out.println("Names: " + builder);