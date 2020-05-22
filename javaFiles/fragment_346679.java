public class TestLabel extends JLabel {

    private Timer timer;

    private Object[][] colors = {{"Black", Color.BLACK},
        {"Blue", Color.BLUE},
        {"Cyan", Color.CYAN},
        {"Dark Gray", Color.DARK_GRAY},
        {"Gray", Color.GRAY},
        {"Green", Color.GREEN},
        {"Light Gary", Color.LIGHT_GRAY},
        {"Mangenta", Color.MAGENTA},
        {"Orange", Color.ORANGE},
        {"Pink", Color.PINK},
        {"Red", Color.RED},
        {"White", Color.WHITE},
        {"Yellow", Color.YELLOW}};

    public TestLabel() {

        setText("Hello world");
        setOpaque(true);

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println("tick");

                int index = (int) Math.round((colors.length - 1) * Math.random());

                Object[] group = colors[index];

                setBackground((Color)group[1]);
                setText((String)group[0]);

            }
        });

        timer.setInitialDelay(0);
        timer.setRepeats(true);
        timer.setCoalesce(true);
        timer.start();

    }
}