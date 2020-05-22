StringBuilder strRst = new StringBuilder();
 strRst.AppendLine(p.StandardOutput.ReadToEnd());
 strRst.AppendLine(p.StandardError.ReadToEnd());
 p.WaitForExit();
 p.Close();
 return strRst.ToString();