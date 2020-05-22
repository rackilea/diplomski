public class Building {

    protected static final Color TRANS_YELLOW = new Color(255, 255, 0, 59);

    private int x, y, width, height;
    private List<Light> lights;

    public Building(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        lights = new ArrayList<>(25);
        int rows = Math.round((height) / 25);
        int columns = Math.round(width / 25);

        for (int j = 1; j <= columns; j++)//windows
        {
            for (int k = 1; k <= rows; k++) {
                Color color = null;
                if (Math.random() < 0.7) {
                    color = Color.YELLOW;
                } else {
                    color = TRANS_YELLOW;
                }
                lights.add(new Light(x + 5 * j + 20 * (j - 1), y + 5 * k + 20 * (k - 1), color));
            }
        }
    }

    public void paint(Graphics2D g2d) {
        g2d.setColor(Color.GRAY);
        g2d.drawRect(x, y, width, height);
        g2d.fillRect(x, y, width, height);
        for (Light light : lights) {
            light.paint(g2d);
        }
    }

    public class Light {

        private int x, y;
        private Color color;

        public Light(int x, int y, Color color) {
            this.x = x;
            this.y = y;
            this.color = color;
        }

        public void paint(Graphics2D g2d) {
            g2d.setColor(Color.BLACK);
            g2d.fillRect(x, y, 20, 20);
            g2d.setColor(color);
            g2d.fillRect(x, y, 20, 20);
        }
    }

}