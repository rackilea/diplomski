[...]

    int width = Integer.parseInt(part1);
    int height = Integer.parseInt(part2);

    int playerPosX = 0;
    int playerPosY = 0;

    for (int h = 0; h < height; h++) {
        for (int w = 0; w < width; w++) {
            String temp = " |";
            if (w == 0) {
                temp = "| |";
            }
            if (playerPosX == w && playerPosY == h) {
                temp = temp.replace(' ', 'X');
            }
            System.out.print(temp);
        }
        System.out.println();
    }

}