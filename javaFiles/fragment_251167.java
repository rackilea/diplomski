for (int i = 0; i < 10; i++) {
    if (i%2 == 0) {
        continue;
    }
    System.out.println(i);
}

int i = 0;
while (i < 10) {
    if (i%2 == 0) {
        continue;
    }
    System.out.println(i);
    i++;
}