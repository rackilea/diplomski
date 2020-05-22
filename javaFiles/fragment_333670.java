public static boolean ListContainsName(List<NameAndPosition> list, String name) {
    for (NameAndPosition nandp : list)
       if (name.equals(nandp.getName()))
         return true;
    return false;
}