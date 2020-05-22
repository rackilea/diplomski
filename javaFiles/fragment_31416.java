Collections.sort(packageList1, new Comparator<PackageInfo>()
{
    @Override
    public int compare(PackageInfo lhs, PackageInfo rhs)
    {
        return String.CASE_INSENSITIVE_ORDER.compare(lhs.packageName, rhs.packageName);
    }
});