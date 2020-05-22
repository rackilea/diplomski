Iterator it = this.iterator();
while (it.hasNext())
{
    Object item = it.next();
    if (o.equals(next)) return false;
}