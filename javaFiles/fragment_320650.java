public int getAnswer()
{
    if (answer.equals("yes"))
        return 0;
    else if (answer.equals("no"))
        return 1;

    return null;
}