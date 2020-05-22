String text = ...;
boolean isInJoin = false;
int start = 0, length = 0, next;
int codePoint;

for (int i = 0; i < text.length(); i = next)
{
    codePoint = text.codePointAt(i);

    if (codePoint == 0x200D)
    {
        isInJoin = true;
        if (length == 0)
        {
            next = text.offsetByCodePoints(i, 1);
            start = next;
            continue;
        }
    }
    else
    {
        if ((length > 0) && (!isInJoin)) break;
        isInJoin = false;
    }

    next = text.offsetByCodePoints(i, 1);
    length += (next - i);
}

if (isInJoin)
{
    for(int i = length-1; i >= 0; --i)
    {
        if (text.charAt(i) == 0x200D)
            --length;
        else
            break;
    }
}

String firstSymbols = text.substring(start, start+length);