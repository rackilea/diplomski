final PackageItemInfo.DisplayNameComparator comparator = new PackageItemInfo.DisplayNameComparator(packageManager);

Collections.sort(packageList1, new Comparator<PackageInfo>()
{
    @Override
    public int compare(PackageInfo lhs, PackageInfo rhs)
    {
        return comparator.compare(lhs.applicationInfo, rhs.applicationInfo);
    }
});