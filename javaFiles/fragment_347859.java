public void keyPressed(KeyEvent e) {
        int i = e.getKeyCode();
        if (i == KeyEvent.VK_A && direction != RIGHT)
                direction = LEFT;

        if (i == KeyEvent.VK_D && direction != LEFT)
                direction = RIGHT;

        if (i == KeyEvent.VK_W && direction != DOWN)
                direction = UP;

        if (i == KeyEvent.VK_S && direction != UP)
                direction = DOWN;


        if(i == KeyEvent.VK_SPACE)
            if(over)
                startGame();
            else
                paused = !paused;           
    }