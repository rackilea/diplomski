int count = 1;
int pagekey = 0;
for(int i = 1; i <= 200; i++)
{
    count++;
    if (i% 50 == 0)
    {
        pagekey++;
        count = 1;
    }
}