enum FruitType {
 YELLOW,GREEN,RED;
}

class Fruit{
 private String name;
 @Enumerated(EnumType.ORDINAL) or @Enumerated(EnumType.STRING)
 private FruitType fruitType;
}