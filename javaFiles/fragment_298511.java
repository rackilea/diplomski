// before
int x, y = 1;
do
{
    //code
    y++;
}while (y <= doors.length);

// after
int x;
for (int y = 1; y <= doors.length; y++)
{
    //code
}