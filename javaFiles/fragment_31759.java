interface MyEnum{}

enum Fruit implements MyEnum {
    Apple
}

Map<MyEnum, String> mp = new HashMap<>();
mp.put(Fruit.Apple, "myapple");