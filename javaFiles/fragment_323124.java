for(int i = 1; i <= column; i++)
{
    ...
}
//because i was declared in the for loop, after the } it no longer exists and we can redeclare and reuse it
for(int i = 1; i <= column; i++)
{
    ...
}