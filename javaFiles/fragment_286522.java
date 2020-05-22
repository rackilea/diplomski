for (int i=0; i<parts.length; i++)
{
    parts[i] = parts[i].replaceAll("\\\\ ", " ");
}

System.out.println(Arrays.toString(parts));
// prints [/path/, /path with space/, /another/]