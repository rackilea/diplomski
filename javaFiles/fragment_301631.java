public class Buildings {

    private int maxX = 784;
    private int maxY = 712;

    private List<Building> buildings;

    public Buildings() {
        buildings = new ArrayList<>(25);
        for (int i = 10; i < 634; i += 10)//buildings
        {
            int width = (int) (Math.random() * 100 + 100);
            int height = (int) (Math.random() * 350 + 100);
            int x = i;
            int y = maxY - height;

            buildings.add(new Building(x, y, width, height));
        }
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        for (Building building : buildings) {
            building.paint(g2d);
        }
    }
}