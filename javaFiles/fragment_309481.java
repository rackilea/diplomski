while (lower <= upper)
{
    curIn = (lower + upper ) / 2;

        if(a[curIn] < value)
            lower = cur + 1;
        else if(a[curIn] > value)
            upper = cur - 1;
        else if (a[curIn] == value)
            break;
}
if(a[curIn] <= value)
    j = curIn + 1;
else j = curIn;