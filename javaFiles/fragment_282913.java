public enum Colors {
    GREY(142, 142, 147),
    RED(255, 59, 48),
    GREEN(76, 217, 100),
    PURPLE(88, 86, 214),
    LIGHTBLUE (52, 170, 220);    //... etc, this is a shorted list

    private final int r;
    private final int g;
    private final int b;
    private final String rgb;

    private Colors(final int r,final int g,final int b) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.rgb = r + ", " + g + ", " + b;
    }

    public String getRGB() {
        return rgb;
    }

    //You can add methods like this too
    public int getRed(){
        return r;
    }

    public int getGreen(){
        return g;
    }

    public int getBlue(){
        return r;
    }

    //Or even these
    public Color getColor(){
        return new Color(r,g,b);
    }

    public int getARGB(){
        return 0xFF000000 | ((r << 16) & 0x00FF0000) | ((g << 8) & 0x0000FF00) | b;
    }
}