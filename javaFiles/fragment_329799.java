public class Start2 extends JFrame implements ActionListener {

    private JButton open;
    private BarChart chart;

    ArrayList<Integer> list = new ArrayList<>();


    public Start2() {
        setSize(800, 500);
        setTitle("BarChart");

        open = new JButton("OPEN");
        open.setSize(100, 30);
        open.addActionListener(this);

        chart = new BarChart(list, "Numbers", "Values");

        this.setLayout(new BorderLayout(2, 2));

        this.add(open, BorderLayout.NORTH);
        this.add(chart, BorderLayout.CENTER);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();

        if (source == open) {
            // revert to the original file input method
            list.clear();
            Random generator = new Random(); 
            for (int i = 0; i < 50; i++) {
                int add =  generator.nextInt(10) + 1;
                System.out.println("adding "+add);
                list.add(add);
            }

            repaint();

        }

    }

    public static void main(String[] args) {
        Start2 frame = new Start2();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}