class Walker {

    // [...]

    void move()
    {
        x = x + speed;

        int man_width = img1.width; 
        if (x <= 0 || x >= width-man_width)
            speed = -speed;
    }
}