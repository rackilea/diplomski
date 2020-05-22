int[] arr = new int[]{1, 2, 3};
//int[] arr = new int[]{1, 2, 3, 4};
//int[] arr = new int[]{1, 2, 3, 4, 5};

GapArray ca = new GapArray(arr);

boolean aTurn = true;
int aScore = 0;
int bScore = 0;

while (ca.size() > 0)
{
    int point;
    int size = ca.size();
    int middle;
    if (size % 2 == 0)
    {
        middle = size / 2;

        if (ca.get(middle - 1) > ca.get(middle))
        {
            point = ca.remove(middle - 1);
        }
        else
        {
            point = ca.remove(middle);
        }
    }
    else
    {
        point = ca.remove(size / 2);
    }
    if (aTurn)
    {
        aScore += point;
        aTurn = false;
    }
    else
    {
        bScore += point;
        aTurn = true;
    }
}
if (aScore == bScore)
{
    System.out.println("Person_A 0");
}
else if (aScore > bScore)
{
    System.out.println("Person_A " + (aScore - bScore));
}
else
{
    System.out.println("Person_B " + (bScore - aScore));
}