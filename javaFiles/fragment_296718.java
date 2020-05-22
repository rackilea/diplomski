List<String> enumA = new ArrayList<>();
for (Enum constant : Elements_1.values())
    enumA.add(constant.name());

List<String> enumB = new ArrayList<>();
for (Enum constant : Elements_2.values())
    enumB.add(constant.name());

enumA.retainAll(enumB);