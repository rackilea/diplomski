void graderate(int ratings)
{
    switch (ratings)
    {
    case 1:
    case 2:
    case 3:
        grade = ("C");
        break;
    case 4:
    case 5:
    case 6:
        grade = ("B");
        break;
    case 7:
    case 8:
    case 9:
        grade = ("A");
        break;
    case 10:
        grade = ("A+");
        break;
    default:
        grade = ("?");
    }
}