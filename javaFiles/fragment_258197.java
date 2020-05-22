public class YourClass {

    private JPanel panel;

    public YourClass() {

        // ...

        scene.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String choice = String.valueOf(scene.getSelectedItem());
                if(choice.equals("Sceneria") || choice.equals("Scene")) {
                    slider.setEnabled(false);
                    YourClass.this.panel = new JPanel();
                    YourClass.this.panel.revalidate();
                    YourClass.this.panel.repaint();
                }
            }
        });
    }
}