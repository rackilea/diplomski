print(p,q);
print(p&q, p|q);
print(p^q, !p);

private void print(boolean left, boolean right)
{
    System.out.println((left?1:0) + "\t" + (right?1:0))
}