public List<String> muckWithStrings(List<String> original)
{
    List<String> newstrings = muckWithTheOriginalStrings(original);
    // You now have your new list of modified Strings
    original.addAll(newstrings);
    return newstrings;
}