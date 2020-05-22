class TrafficLight2 {
    private static final int ELLIPSE_W = 40;
    private static final int GAP = 4;
    private int x;
    private int y;
    private LightState lightState = LightState.RED; // what color is bright

    // map to hold our 3 ellipses, each one corresponding to a LightState
    private Map<LightState, Shape> lightMap = new EnumMap<>(LightState.class);

    public TrafficLight2(int x, int y) {
        // create 3 ellipses, one each for RED, YELLOW, GREEN
        // place each one below the previous
        // associate each one with one of our RED, YELLOW, or GREEN LightStates
        // putting the Ellipse into the map with the light state as key
        this.x = x;
        this.y = y;
        int tempX = x + GAP;
        int tempY = y + GAP;
        lightMap.put(LightState.RED, new Ellipse2D.Double(tempX, tempY, ELLIPSE_W, ELLIPSE_W));
        tempY += ELLIPSE_W + GAP;
        lightMap.put(LightState.YELLOW, new Ellipse2D.Double(tempX, tempY, ELLIPSE_W, ELLIPSE_W));
        tempY += ELLIPSE_W + GAP;
        lightMap.put(LightState.GREEN, new Ellipse2D.Double(tempX, tempY, ELLIPSE_W, ELLIPSE_W));
    }

    // called by JPanel's paintComponent
    public void draw(Graphics2D g2) {
        // iterate through the 3 LightStates
        for (LightState ltSt : LightState.values()) {
            // if the ltSt in the for loop is this traffic light's LightState
            // then the display color should be bright
            Color c = ltSt == lightState ? ltSt.getColor() : 
                // other wise the display color should be very dark
                ltSt.getColor().darker().darker().darker();
            g2.setColor(c);
            g2.fill(lightMap.get(ltSt)); // fill the oval with color
            g2.setColor(Color.BLACK);
            g2.draw(lightMap.get(ltSt));  // draw a black border
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public LightState getLightState() {
        return lightState;
    }

    public void setLightState(LightState lightState) {
        this.lightState = lightState;
    }

    // static method for the width of our traffic lights
    public static int getWidth() {
        return 2 * GAP + ELLIPSE_W;
    }

    // static method for the height of our traffic lights
    public static int getHeight() {
        return 4 * GAP + 3 * ELLIPSE_W;
    }
}