Comparator<AccountType> comparator = (o1, o2) -> {
    if(Objects.equals(o1.type, "rrsp")) return -1;
    else if(Objects.equals(o2.type, "rrsp")) return 1;
    else if(Objects.equals(o1.type, "tfsa")) return -1;
    else if(Objects.equals(o2.type, "tfsa")) return 1;
    else return o1.compareTo(o2);
};
accountTypes.sort(comparator);