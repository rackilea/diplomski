boolean[] doors = new boolean[100];
for (int y = 1; y <= doors.length; y++)
    for (int x = y - 1; x < doors.length - 1; x += y)
        doors[x] ^= true;
for (boolean b : doors)
    System.out.println(b);