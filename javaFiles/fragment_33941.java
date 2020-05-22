static boolean canTakeExam(String s)
{
    for(int i=0, ca=0, cl=0; i<s.length(); i++)
    {
        char c = s.charAt(i);
        if(c == 'A')
        {
            if(++ca == 3) return false;
        }
        else
        {
            if(c == 'L' && ++cl == 4) return false;
            ca = 0;
        }
    }
    return true;
}