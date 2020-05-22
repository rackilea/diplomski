int value = Integer.parseInt("1000101010", 2);

int bitCounter = 0;
for (int i = 0; i < Integer.SIZE; i++) {
    if (((1 << i) & value) > 0) {
        bitCounter++;
    }
}
System.out.println(value + " has " + bitCounter + " bits");