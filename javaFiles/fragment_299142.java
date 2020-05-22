new Comparator<PackagInfo>() {
    @Override
    public int compare(PackagInfo arg0, PackagInfo arg1) {
      return arg0.getName().compareTo(arg1.getName());
    }
 };