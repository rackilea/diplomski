logmsg = CreateLogMessage(new string [] {"Line1", "Line2"});

public static CreateLogMessage(string[] argLines);
{
  StringBuilder sb = new StringBuilder(argLines.Length);
  foreach(String line in argLines)
  {
    sb.AppendLine(line);
  }
  return sb.ToString();
}