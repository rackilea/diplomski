public class Test extends JFrame {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        JButton button = new JButton("play");
        button.addActionListener(new  ActionListener() {
        public void actionPerformed(ActionEvent e) {
                playSound();
        }});
        this.getContentPane().add(button);
        this.setVisible(true);
    }

    public void playSound() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("beep.wav"));
            Clip clip = AudioSystem.getClip( );
            clip.open(audioInputStream);
            clip.start( );
        }
        catch(Exception e)  {
            e.printStackTrace( );
        }
    }
}