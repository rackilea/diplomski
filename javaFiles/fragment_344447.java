String line = null;
while ((line = br.readLine()) != null) 
{
    loadProperties(line);
    sb.append(line);
    sb.append("\n");
    line = br.readLine();
}