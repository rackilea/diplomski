if (boom)
{
    t1 = Time.current();
    t2 = t1 + 30000L;
    while (t1 < t2) {
        MarkTarget();
        t1 = Time.current();
    }
}