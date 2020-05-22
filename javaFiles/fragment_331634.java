enum EnumA {
    FIRST,
    SECOND,
    THIRD
}

enum EnumB {
    FIRST,
    SECOND,
    THIRD
}

private static <A extends Enum<A>, B extends Enum<B>> List<B> enumListFromEnumList(List<A> sourceEnumsList, Class<B> classObject) {
    List<B> enums = new ArrayList<B>();

    if (sourceEnumsList != null) {
        for (A enumObject : sourceEnumsList) {
            enums.add(Enum.valueOf(classObject, enumObject.toString().toUpperCase()));
        }
    }

    return enums;
}

public static void main(String[] args) {
    List<EnumA> listA = new ArrayList<EnumA>();
    listA.add(EnumA.FIRST);
    listA.add(EnumA.THIRD);
    List<EnumB> listB = enumListFromEnumList(listA, EnumB.class);
    System.out.println(listB);
}