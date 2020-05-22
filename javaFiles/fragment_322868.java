@SuppressWarnings("serial")
class PlayerPanel extends JPanel {
   private Player player;
   private JButton fireButton = new JButton("Fire");
   private JSlider healthSlider;

   public PlayerPanel(final Player player) {
      this.player = player;
      setBorder(BorderFactory.createTitledBorder("Player: " + 
             player.getName()));

      healthSlider = new JSlider(0, 100, player.getHealth());
      healthSlider.setBorder(BorderFactory.createTitledBorder("Health"));
      healthSlider.setPaintLabels(true);
      healthSlider.setPaintTicks(true);
      healthSlider.setPaintTicks(true);
      healthSlider.setMajorTickSpacing(20);
      healthSlider.setMinorTickSpacing(5);

      add(healthSlider);
      add(fireButton);

      healthSlider.addChangeListener(new ChangeListener() {

         @Override
         public void stateChanged(ChangeEvent evt) {
            player.setHealth(healthSlider.getValue());
         }
      });

      player.addPropertyChangeListener(new PropertyChangeListener() {

         @Override
         public void propertyChange(PropertyChangeEvent evt) {
            if (evt.getPropertyName().equals(Player.HEALTH)) {
               fireButton.setEnabled(player.getHealth() > 0);
            }
         }
      });

   }

   public Player getPlayer() {
      return player;
   }

}