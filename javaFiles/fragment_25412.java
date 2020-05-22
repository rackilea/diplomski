public static void main(String[] args) {
    JFrame frame = new JFrame("Test");

    final int[][] map = new int[10][10];
    Random r = new Random(321);
    for (int i = 0; i < map.length; i++)
        for (int j = 0; j < map[0].length; j++)
            map[i][j] = r.nextBoolean() ? r.nextInt() : 0;

    frame.add(new JComponent() {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            int w = getWidth() / map.length;
            int h = getHeight() / map[0].length;

            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[0].length; j++) {
                    if (map[i][j] != 0) {
                        g.setColor(new Color(map[i][j]));
                        g.fillRect(i * w, j * h, w, h);
                    }
                }
            }
        }
    });

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 400);
    frame.setVisible(true);
}