class MyStringComparator<String> implements Comparator
{
    public int compareTo(String a, String b)
    {
        return a.compareTo(b) * -1; //Reverse the order. 
                                    //The logic can be as complex as your need is
    }
}