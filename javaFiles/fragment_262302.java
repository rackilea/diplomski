string input = "Mountain View, CA 94043";
string pattern = @"^(?i:(?:([^\d,]+?)\W+\b((?:CA|SD|SC|CT|DC)\b)?\W*)?(\d{5}(?:[- ]\d{3,4})?)?)$";

Match m = Regex.Match(input, pattern);

foreach (Group g in m.Groups)
{
    Console.WriteLine(g.Value);
}