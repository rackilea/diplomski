int x = 3, p =0;
for (int i = 0; i < x; i++)
{
    if (gameboard[i] == 1)
         p++;
}
if (p == x)
    return winner;