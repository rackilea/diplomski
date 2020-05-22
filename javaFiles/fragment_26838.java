final int CATEGORY_DRINK = 0;
final int CATEGORY_FRUIT = 1;
final int CATEGORY_MEAT = 2;
final int CATEGORY_VEGETABLE = 3;
final int CATEGORY_COUNT = 4;

int repeat = list.size() / CATEGORY_COUNT; //2
for(int i = 0; i < repeat; i++) {
    int offset = i * CATEGORY_COUNT;
    String drink = list.get(CATEGORY_DRINK + offset);
    String fruit = list.get(CATEGORY_FRUIT + offset);
    String meat = list.get(CATEGORY_MEAT + offset);
    String vegi = list.get(CATEGORY_VEGETABLE + offset);
}