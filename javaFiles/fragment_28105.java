string pattern = @"^\d+";
MatchCollection mc = Regex.Matches(myString, pattern);
if(mc.Count > 0)
{
  Console.WriteLine(mc[0].Value.Length);
}