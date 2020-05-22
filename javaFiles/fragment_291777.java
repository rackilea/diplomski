public final class MyEquivalence
    extends Equivalence<String[]>
{
    @Override
    protected boolean doEquivalent(final String[] a, final String[] b)
    {
        return Arrays.equals(a, b);
    }

    @Override
    protected int doHash(final String[] t)
    {
        return Arrays.hashCode(t);
    }
}