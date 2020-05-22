if (spawnX == 0 || blocked(spawnX - 1, spawnY)) {
            left = false;
            System.out.println("You can't go left!");
        }           
        if (spawnX == 12 || blocked(spawnX + 1, spawnY)) {
            right = false;
            System.out.println("You can't go right!");
        }
        if (spawnY ==0 || blocked(spawnX, spawnY - 1)) {
            up = false;
            System.out.println("You can't go up!");
        }
        if (spawnY == 8 || blocked(spawnX, spawnY + 1)) {
            down = false;
            System.out.println("You can't go down!");
        }