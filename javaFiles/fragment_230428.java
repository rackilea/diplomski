if (items.length != 0) {
    System.out.print("The values are: ");
}
for (int i = 0; i < items.length; ++i) {
    if (items.length == 1) {
        System.out.print("The value is: " + items[i]);
    } else {
        if (i != 0) {
            System.out.print(", ");
        }
        System.out.print(items[i]);
    }
}
System.out.println();