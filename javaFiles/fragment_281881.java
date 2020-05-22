case KeyEvent.VK_ESCAPE:
    direction = -direction;

    if (direction < 0) {
        add(options);
    } else {
        remove(options);
    }