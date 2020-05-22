synchronized
{
    vector.add(a);
    vector.add(b);
/*
 * a and b are always added to the vector in sequence.
 * If two threads execute this block, the vector will contain {a,b,a,b}.
 */
}