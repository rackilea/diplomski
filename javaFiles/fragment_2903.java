long start = 0;
long stop = Long.parseLong("ZZZZZ", 36);

for (long i = start; i <= stop; ++i)
{
    System.out.println(Long.toString(i, 36).toUpperCase());
}