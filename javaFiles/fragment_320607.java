int y = -1;
for (Map.Entry<Coords, Character> e: map.entrySet()) {
    if (e.y != y) {
        if (y != -1) System.out.println();
        y = e.y;
    }
    System.out.print(c);
}