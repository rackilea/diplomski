int i;

i = 0;
do {
    ++i;
    System.out.println("Before: " + i);
    if (someSpecialCondition) {
        break;
    }
    System.out.println("After: " + i);
}
while (i < 5);