// ...

MatchCollection matches = rx.Matches(myString);
foreach (Match match in matches)
{
    GroupCollection groupCollection = match.Groups;
    Console.WriteLine("serial " + groupCollection[1].ToString());
}