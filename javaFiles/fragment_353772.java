public InputStream oracleWorkaroundStream(String fileName) throws IOException
{
  String ls = System.getProperty("line.separator");

  // This pattern isolates the table name from the rest of the line
  Pattern pattern = Pattern.compile("(\\s*<)(\\w+)(.*/>)");

  FileInputStream fis = new FileInputStream(fileName);
  // Use a StringBuidler for better performance over repeated concatenation
  StringBuilder sb = new StringBuilder(fis.available()*2);

  InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
  BufferedReader buff = new BufferedReader(isr);
  while (buff.ready())
  {
    // Read a line from the source xml file
    String line = buff.readLine();
    Matcher matcher = pattern.matcher(line);

    // See if the line contains a table name
    if (matcher.matches())
    {
      String tableName = matcher.group(2);
      if (tableName.length() > 30)
      {
        tableName = tableName.substring(0, 30);
      }

      // Append the (potentially modified) line
      sb.append(matcher.group(1));
      sb.append(tableName);
      sb.append(matcher.group(3));
    }
    else
    {
      // Some lines don't have tables names (<dataset>, <?xml?>, etc.)
      sb.append(line);
    }
    sb.append(ls);
  }

  return new ByteArrayInputStream(sb.toString().getBytes("UTF-8"));
}