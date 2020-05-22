@Override
public int compareTo (WeaponObject compare)
{
    int superCompare = super.compareTo(compare);

    if(superCompare != 0)
    {
        return superCompare;
    }

    if(compare instanceof Sword) {
        Sword other = (Sword)compare;

        int attach = this.getSwordAttahment().compareTo(other.getSwordAttahment());

        if(attach != 0)
        {
            return attach;
        }
    }

    return 0;
}