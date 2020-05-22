Slot[][] s = new Slot[width][height];

for (int i = 0; i < height; i++) {

    for (int j = 0; j < width; j++) {
        s[j][i](new Slot(j, i));
    }
}

for (int i = 0; i <= height; i++) {
        for (int j = 0; j <= width; j++) {
            System.out.print(s[j][i]);
        }
        System.out.println("");
    }