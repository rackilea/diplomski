public class Tower extends Unit implements ActionListener {

    private final Timer fireTimer;
    private final Map map;
    private int damage;
    private int range;

    public Tower(Map map, int damage, int range, int fireRate) {
        this.map = map;
        this.damage = damage;
        this.range = range;
        fireTimer = new Timer(fireRate, this);
        fireTimer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == fireTimer) {
            map.damageNearestUnit(this, range, damage);
        }
    }

}