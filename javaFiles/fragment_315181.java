String bar = "#";

    public void addTick()
    {
        if(bar.length() < maxBarLength) {
            bar = bar + "#";
            drawBar(bar);
        }
    }

    public void draw()
    {
        drawBar(bar);
    }

    public void paint()
    {
        // draw some stuff
        draw(bar);
    }