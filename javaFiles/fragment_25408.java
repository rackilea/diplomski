public class MyClass extends JComponent {
    HashMap<String, Color> map = new HashMap<>();
    private static final String BOY = "B";
    private static final String GIRL = "G";

    public MyClass() {
        String[] peopleArray = new String[people.size()];
        map.put(BOY, Color.RED);
        map.put(GIRL, Color.GREEN);
        for (int i = 0; i < people.size(); i++) {
            if (people.get(i) instanceof Boy) {
            peopleArray[i] = BOY;
            System.out.print(BOY);
        } else if (people.get(i) instanceof Girl) {
            peopleArray[i] = GIRL;
            System.out.print(GIRL);
        }
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        //you might need a for-loop or smth here. I'll just draw a boy in this example.
        g.setColor(map.get(BOY));
        int x = 10;
        int y = 10;
        g.drawString(BOY, x, y);
    }
}