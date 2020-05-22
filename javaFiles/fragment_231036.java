if(((EntityDamageByEntityEvent) player.getLastDamageCause()).getDamager() instanceof Arrow) {
    Arrow arrow = (Arrow) ((EntityDamageByEntityEvent) player.getLastDamageCause()).getDamager();
    ProjectileSource shooter = arrow.getShooter();

       if(shooter instanceof Player) // checking if the shooter is a player.
       {
          Player shooterPlayer = (Player) shooter;
          shooterPlayer.sendMessage("You hitted someone with a bow right?");
          player.sendMessage("You got hit by a bow..");
       }
}