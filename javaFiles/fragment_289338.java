char s[30];
int p;
for (;;) // repeat forever: you cannot use a realistic iteration limit anyway
{
    for (p = 0; p < 29; ++p)
        s[p] = 'a' + rand() % 26;
    s[29] = '\0';
    puts(s);
}