public class AnimationViewer extends JFrame {
JButton jbtFlash = new JButton("Flash");
JButton jbtSteady = new JButton("Steady");
JPanel bPanel = new JPanel();
Sphere sphPanel = new Sphere();
Timer timer;

public AnimationViewer() {
   this.add(bPanel, BorderLayout.SOUTH);
   bPanel.add(jbtFlash);
   bPanel.setLayout(new GridLayout(1,2));
   bPanel.add(jbtSteady);

   this.add(sphPanel, BorderLayout.CENTER);

   timer = new Timer(100, new TimerListener());
   jbtSteady.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            sphPanel.choosesteady();
            timer.stop();
            sphPanel.repaint();
        }
    });
   jbtFlash.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            sphPanel.chooseflashinglights();
            timer.start();
        }
    });

}

class TimerListener implements ActionListener {
   public void actionPerformed(ActionEvent e) {
       sphPanel.repaint();
   }
}

}