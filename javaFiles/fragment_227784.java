public class DamageButton extends JButton {

    private String damage = null;

    public DamageButton(String text) {
        super(text);
    }

    public void setDamage(String damage) {
        this.damage = damage;
        System.out.println(damage);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (damage != null) {
            Graphics2D gg = (Graphics2D) g.create();
            try {
                gg.setColor(Color.RED);
                gg.drawString(damage, 10, 10);
            } finally {
                gg.dispose();
            }
        }
    }
}