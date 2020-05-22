String text = ...;
StringBuilder sequence = new StringBuilder(text.length());
boolean isInJoin = false;
int codePoint;

for (int i = 0; i < text.length(); i = text.offsetByCodePoints(i, 1))
{
    codePoint = text.codePointAt(i);

    if (codePoint == 0x200D)
    {
        isInJoin = true;
        if (sequence.length() == 0)
            continue;
    }
    else
    {
        if ((sequence.length() > 0) && (!isInJoin)) break;
        isInJoin = false;
    }

    sequence.appendCodePoint(codePoint);
}

if (isInJoin)
{
    for(int i = sequence.length()-1; i >= 0; --i)
    {
        if (sequence.charAt(i) == 0x200D)
            sequence.deleteCharAt(i);
        else
            break;
    }
}

String firstSymbols = sequence.toString();