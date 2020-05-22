string myString = "B12";
Regex rx = new Regex(@"[A-Za-z](\\d+)");
MatchCollection matches = rx.Matches(myString);
if (matches.Count > 0)
{
    Match match = matches[0]; // only one match in this case
    GroupCollection groupCollection = match.Groups;
    Console.WriteLine("serial " + groupCollection[1].ToString());
}