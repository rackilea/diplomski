int[] data = new int[200];
JPanel panel;
JPanel buttonsPanel = new JPanel();
JButton mButton = new JButton("Mergesort");

int barWidth = 8;
int barHeight = 1;

class ArrayPanel extends JPanel {
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        int xPos = 0;
        for (int i = 0; i < data.length; i++) {
            System.out.println("Drawing " + i);
            g.fillRect(xPos, (barHeight * 500) - (barHeight * data[i]), barWidth, barHeight * data[i]);
            xPos += barWidth;
        }   
    }
}


public void actionPerformed(ActionEvent e) {
    Arrays.sort(data);
    panel.repaint();
}